package com.mentos74.drugsapp.web.controller;

import com.mentos74.drugsapp.web.dto.ActiveIngredientDTO;
import com.mentos74.drugsapp.web.entity.Attachment;
import com.mentos74.drugsapp.web.enums.AttachmentType;
import com.mentos74.drugsapp.web.service.ActiveIngredientService;
import com.mentos74.drugsapp.web.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


//benerin upload jangan pake base64

@Controller
public class ActiveIngredientController {

    @Autowired
    ActiveIngredientService activeIngredientService;

    @Autowired
    AttachmentService attachmentService;

    //todo kalo di edit terus attachmentnya kosong masih error, tapi kalo ada attachmentnya ga error.

    @GetMapping("/active-ingredient/list")
    public String listActiveIngredients(Model model) {
        List<ActiveIngredientDTO> listIngredients = activeIngredientService.listActiveIngredient();
        model.addAttribute("listIngredients", listIngredients);
        return "active_ingredient/list_activeIngredient";
    }

    @PostMapping("/active-ingredient/edit")
    public ResponseEntity<?> editIngredient(@ModelAttribute ActiveIngredientDTO dto,
                                            @RequestParam("chemicalStructureFile") MultipartFile file) {
        try {
            Attachment attachment = new Attachment();
            if (file != null && !file.isEmpty()) {
                try {
                    attachment = attachmentService.saveAttachment(file, AttachmentType.CHEMICAL_FORMULA_PHOTO);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            activeIngredientService.updateActiveIngredient(dto, attachment);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }

    @PostMapping("/active-ingredient/add")
    public ResponseEntity<?> addIngredient(@ModelAttribute ActiveIngredientDTO dto,
                                           @RequestParam("chemicalStructureFile") MultipartFile file) {
        try {
            Attachment attachment = new Attachment();
            if (file != null && !file.isEmpty()) {
                try {
                     attachment = attachmentService.saveAttachment(file, AttachmentType.CHEMICAL_FORMULA_PHOTO);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            activeIngredientService.createNewActiveIngredient(dto,attachment);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }

    @GetMapping("/active-ingredient/detail/{id}")
    public ResponseEntity<?> getIngredientById(@PathVariable Long id) {
        ActiveIngredientDTO activeIngredientDTO = activeIngredientService.findActiveIngredientById(id);
        if (activeIngredientDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("status", "not_found"));
        }

        return ResponseEntity.ok(activeIngredientDTO);
    }


    @PostMapping("/active-ingredient/delete/{id}")
    public ResponseEntity<?> deleteActiveIngredient(@PathVariable Long id) {
        try {
            activeIngredientService.deleteActiveIngredient(id);
        } catch (Exception e) {
            return ResponseEntity.ok(Collections.singletonMap("status", "error"));
        }
        return ResponseEntity.ok(Collections.singletonMap("status", "success"));
    }

}
