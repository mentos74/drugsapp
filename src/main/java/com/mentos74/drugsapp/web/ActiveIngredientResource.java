package com.mentos74.drugsapp.web;

import com.mentos74.drugsapp.dto.ActiveIngredientDTO;
import com.mentos74.drugsapp.service.ActiveIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

//todo dijadiin submit ajax aja besok

@Controller
public class ActiveIngredientResource {

    @Autowired
    ActiveIngredientService activeIngredientService;

    @GetMapping("/active-ingredient/list")
    public String listActiveIngredients(Model model) {
        List<ActiveIngredientDTO> listIngredients = activeIngredientService.listActiveIngredient();
        model.addAttribute("listIngredients", listIngredients);
        return "active_ingredient/list_activeIngredient";
    }

    @PostMapping("/active-ingredient/edit/{id}")
    public ResponseEntity<String> editIngredient(@PathVariable Long id, @ModelAttribute ActiveIngredientDTO dto,
                                                 @RequestParam("chemicalStructureFile") MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                String encodedFile = Base64.getEncoder().encodeToString(file.getBytes());
                dto.setChemicalStructure(encodedFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        activeIngredientService.updateActiveIngredient(dto);
        return ResponseEntity.ok("Sukses Edit");
    }

    @PostMapping("/active-ingredient/add")
    public ResponseEntity<String> addIngredient( @ModelAttribute ActiveIngredientDTO dto,
                                                 @RequestParam("chemicalStructureFile") MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                String encodedFile = Base64.getEncoder().encodeToString(file.getBytes());
                dto.setChemicalStructure(encodedFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        activeIngredientService.createNewActiveIngredient(dto);
        return ResponseEntity.ok("Sukses Add");
    }


//    @GetMapping("/active-ingredient/add")
//    public String addActiveIngredient(Model model) {
//        model.addAttribute("dto", new ActiveIngredientRequestDTO());
//        return "/active_ingredient/add_activeIngredient :: modalContent";
//    }
//
//
//
//
//    @PostMapping("/active-ingredient/add")
//    public String addActiveIngredientNew(
//            @ModelAttribute("dto") @Valid ActiveIngredientRequestDTO addActiveDTO,
//            BindingResult bindingResult,
//            @RequestParam("chemicalStructureFile") MultipartFile file,
//            Model model) {
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("dto", addActiveDTO);
//            return "/active_ingredient/add_activeIngredient :: modalContent";
//        }
//
//        if (file != null && !file.isEmpty()) {
//            try {
//                String encodedFile = Base64.getEncoder().encodeToString(file.getBytes());
//                addActiveDTO.setChemicalStructure(encodedFile);
//            } catch (IOException e) {
//                bindingResult.rejectValue("chemicalStructure", "error.fileUpload", "Failed to process file.");
//                model.addAttribute("dto", addActiveDTO);
//                return "/active_ingredient/add_activeIngredient :: modalContent";
//            }
//        }
//
//        activeIngredientService.createNewActiveIngredient(addActiveDTO);
//
//        return "redirect:/active-ingredient/list";
//    }
//
//
//    @GetMapping("/active-ingredient/edit/{id}")
//    public String editActiveIngredient(@PathVariable Long id, Model model) {
//        ActiveIngredientRequestDTO editActiveDTO = activeIngredientService.findActiveIngredientById(id);
//        model.addAttribute("dto", editActiveDTO);
//        return "/active_ingredient/edit_activeIngredient :: modalContent";
//    }
//
//    @PostMapping("/active-ingredient/edit/{id}")
//    public String editActiveIngredientNew(@PathVariable Long id,
//            @ModelAttribute("dto") @Valid ActiveIngredientRequestDTO editActiveDTO,
//            BindingResult bindingResult,
//            @RequestParam("chemicalStructureFile") MultipartFile file,
//            Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("dto", editActiveDTO);
//            return "/active_ingredient/edit_activeIngredient :: modalContent";
//        }
//
//        if (file != null && !file.isEmpty()) {
//            try {
//                String encodedFile = Base64.getEncoder().encodeToString(file.getBytes());
//                editActiveDTO.setChemicalStructure(encodedFile);
//            } catch (IOException e) {
//                bindingResult.rejectValue("chemicalStructure", "error.fileUpload", "Failed to process file.");
//                model.addAttribute("dto", editActiveDTO);
//                return "/active_ingredient/edit_activeIngredient :: modalContent";
//            }
//        }
//
//        activeIngredientService.updateActiveIngredient(editActiveDTO);
//
//        System.out.println("masuk sini jir4");
//        return "redirect:/active-ingredient/list";
//    }


    @PostMapping("/active-ingredient/delete/{id}")
    public String deleteActiveIngredient(@PathVariable Long id){

        activeIngredientService.deleteActiveIngredient(id);

        return "redirect:/active-ingredient/list";
    }
}
