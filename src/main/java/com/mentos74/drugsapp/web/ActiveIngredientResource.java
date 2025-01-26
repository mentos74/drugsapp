package com.mentos74.drugsapp.web;


import com.mentos74.drugsapp.dto.ActiveIngredientCreateRequestDTO;
import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ActiveIngredientResource {

    @Autowired
    ActiveIngredientService activeIngredientService;

    @GetMapping("/active-ingredient/list")
    public String listActiveIngredients() {

        List<ActiveIngredientResponseRequestDTO> listAI = activeIngredientService.listActiveIngredient();

        return ("/ActiveIngredient/list_activeIngredient");
    }


    @GetMapping("/active-ingredient/add")
    public String addActiveIngredient(Model model) {
        ActiveIngredientCreateRequestDTO addActiveDTO = new ActiveIngredientCreateRequestDTO();
        model.addAttribute("dto", addActiveDTO);
        return ("/ActiveIngredient/add_activeIngredient");
    }


    @PostMapping("/active-ingredient/add")
    public String addActiveIngredientNew(
            @ModelAttribute("dto") @Valid ActiveIngredientCreateRequestDTO addActiveDTO,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("dto", addActiveDTO);
            return "/ActiveIngredient/add_activeIngredient";
        }

        // Handle file upload
        MultipartFile file = addActiveDTO.getChemicalStructure();
        if (file != null && !file.isEmpty()) {
            try {
                String uploadDir = "uploads/"; // Folder tujuan penyimpanan
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath); // Buat folder jika belum ada
                }
                String fileName = file.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                file.transferTo(filePath.toFile()); // Simpan file ke disk

                // Simpan path file ke DTO untuk penyimpanan di database
                addActiveDTO.setChemicalStructure(null); // Opsional, bisa diganti field string untuk path
            } catch (Exception e) {
                bindingResult.rejectValue("chemicalStructure", "error.fileUpload", "Failed to upload file.");
                model.addAttribute("dto", addActiveDTO);
                return "/ActiveIngredient/add_activeIngredient";
            }
        }

        // Simpan data ke database menggunakan service
        activeIngredientService.createNewActiveIngredient(addActiveDTO);

        return "redirect:/active-ingredient/list";
    }

}
