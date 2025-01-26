package com.mentos74.drugsapp.web;

import com.mentos74.drugsapp.dto.ActiveIngredientCreateRequestDTO;
import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.mentos74.drugsapp.service.ActiveIngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
