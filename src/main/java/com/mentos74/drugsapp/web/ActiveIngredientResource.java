package com.mentos74.drugsapp.web;

import com.mentos74.drugsapp.dto.ActiveIngredientCreateRequestDTO;
import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;

import java.io.IOException;

import com.mentos74.drugsapp.dto.ActiveIngredientUpdateRequestDTO;
import com.mentos74.drugsapp.service.ActiveIngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;

@Controller
public class ActiveIngredientResource {

    @Autowired
    ActiveIngredientService activeIngredientService;

    @GetMapping("/active-ingredient/list")
    public String listActiveIngredients(Model model) {
        List<ActiveIngredientResponseRequestDTO> listIngredients = activeIngredientService.listActiveIngredient();
        model.addAttribute("listIngredients", listIngredients);
        return "/ActiveIngredient/list_activeIngredient";
    }

    @GetMapping("/active-ingredient/add")
    public String addActiveIngredient(Model model) {
        ActiveIngredientCreateRequestDTO addActiveDTO = new ActiveIngredientCreateRequestDTO();
        model.addAttribute("dto", addActiveDTO);
        return "/ActiveIngredient/add_activeIngredient";
    }

    @PostMapping("/active-ingredient/add")
    public String addActiveIngredientNew(
            @ModelAttribute("dto") @Valid ActiveIngredientCreateRequestDTO addActiveDTO,
            BindingResult bindingResult,
            @RequestParam("chemicalStructureFile") MultipartFile file,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("dto", addActiveDTO);
            return "/ActiveIngredient/add_activeIngredient";
        }

        if (file != null && !file.isEmpty()) {
            try {
                String encodedFile = Base64.getEncoder().encodeToString(file.getBytes());
                addActiveDTO.setChemicalStructure(encodedFile);
            } catch (IOException e) {
                bindingResult.rejectValue("chemicalStructure", "error.fileUpload", "Failed to process file.");
                model.addAttribute("dto", addActiveDTO);
                return "/ActiveIngredient/add_activeIngredient";
            }
        }

        activeIngredientService.createNewActiveIngredient(addActiveDTO);

        return "redirect:/active-ingredient/list";
    }


    @GetMapping("/active-ingredient/edit/{id}")
    public String editActiveIngredient(@PathVariable Long id,Model model) {
        ActiveIngredientUpdateRequestDTO editActiveDTO = activeIngredientService.findActiveIngredientById(id);
        model.addAttribute("dto", editActiveDTO);
        return "/ActiveIngredient/edit_activeIngredient";
    }

    @PostMapping("/active-ingredient/edit/{id}")
    public String editActiveIngredientNew(@PathVariable Long id,
            @ModelAttribute("dto") @Valid ActiveIngredientUpdateRequestDTO editActiveDTO,
            BindingResult bindingResult,
            @RequestParam("chemicalStructureFile") MultipartFile file,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("dto", editActiveDTO);
            return "/ActiveIngredient/edit_activeIngredient";
        }

        if (file != null && !file.isEmpty()) {
            try {
                String encodedFile = Base64.getEncoder().encodeToString(file.getBytes());
                editActiveDTO.setChemicalStructure(encodedFile);
            } catch (IOException e) {
                bindingResult.rejectValue("chemicalStructure", "error.fileUpload", "Failed to process file.");
                model.addAttribute("dto", editActiveDTO);
                return "/ActiveIngredient/edit_activeIngredient";
            }
        }

        activeIngredientService.updateActiveIngredient(editActiveDTO);

        return "redirect:/active-ingredient/list";
    }


    @PostMapping("/active-ingredient/delete/{id}")
    public String deleteActiveIngredient(@PathVariable Long id){

        activeIngredientService.deleteActiveIngredient(id);

        return "redirect:/active-ingredient/list";
    }
}
