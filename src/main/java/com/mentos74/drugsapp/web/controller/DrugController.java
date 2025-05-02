package com.mentos74.drugsapp.web.controller;

import com.mentos74.drugsapp.web.dto.DrugDTO;
import com.mentos74.drugsapp.web.entity.Attachment;
import com.mentos74.drugsapp.web.enums.AttachmentType;
import com.mentos74.drugsapp.web.service.AttachmentService;
import com.mentos74.drugsapp.web.service.DrugService;
import jakarta.validation.Valid;
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


@Controller
public class DrugController {

    @Autowired
    DrugService drugService;

    @Autowired
    AttachmentService attachmentService;

    //todo bikin detail, benerin yang save get update ke table lainnya

    @GetMapping("/drug/list")
    public String listDrug(Model model) {
        List<DrugDTO> listDrugs = drugService.listDrugs();
        model.addAttribute("listDrugs", listDrugs);
        return "/drug/list_drug";
    }


    @PostMapping("/drug/add")
    public ResponseEntity<?> addNewDrug(@ModelAttribute("dto") @Valid DrugDTO dto,
                                        @RequestParam(value = "activeIngredients", required = false) List<Long> activeIngredientIds,
                                        @RequestParam(value = "drugClasses", required = false) List<Long> drugClassIds,
                                        @RequestParam("drugPhotoFile") MultipartFile file) {
        try {
            Attachment attachment = null;
            if (file != null && !file.isEmpty()) {
                try {
                    attachment = attachmentService.saveAttachment(file, AttachmentType.DRUG_PHOTO);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            drugService.createDrug(dto, activeIngredientIds, drugClassIds, attachment);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }


    @PostMapping("/drug/edit")
    public ResponseEntity<?> editDrug(@ModelAttribute("dto") @Valid DrugDTO dto,
                                      @RequestParam(value = "activeIngredients", required = false) List<Long> activeIngredientIds,
                                      @RequestParam(value = "drugClasses", required = false) List<Long> drugClassIds,
                                      @RequestParam("drugPhotoFile") MultipartFile file) {
        try {
            Attachment attachment = null;
            if (file != null && !file.isEmpty()) {
                try {
                    attachment = attachmentService.saveAttachment(file, AttachmentType.DRUG_PHOTO);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            drugService.updateDrug(dto, activeIngredientIds, drugClassIds, attachment);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }

    @PostMapping("/drug/delete/{id}")
    public ResponseEntity<?> deleteDrug(@PathVariable Long id) {
        try {
            drugService.deleteDrug(id);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }


}
