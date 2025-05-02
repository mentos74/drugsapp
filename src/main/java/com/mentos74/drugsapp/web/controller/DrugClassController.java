package com.mentos74.drugsapp.web.controller;

import com.mentos74.drugsapp.web.dto.DrugClassDTO;
import com.mentos74.drugsapp.web.service.DrugClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class DrugClassController {

    @Autowired
    DrugClassService drugClassSevice;


    @GetMapping("/drug-class/list")
    public String listDrugClass(Model model) {

        List<DrugClassDTO> listDrugClass = drugClassSevice.listDrugClass();
        model.addAttribute("listDrugClass", listDrugClass);

        return "/drug_class/list_drugClass";
    }

    @PostMapping("drug-class/add")
    public ResponseEntity<?> addDrugClass(@ModelAttribute DrugClassDTO dto) {
        try {

            drugClassSevice.createDrugClass(dto);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }

    @PostMapping("/drug-class/edit")
    public ResponseEntity<?> editDrugClassNew(@ModelAttribute DrugClassDTO dto) {
        try {
            drugClassSevice.updateDrugClass(dto);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }


    @PostMapping("/drug-class/delete/{id}")
    public ResponseEntity<?> deleteDrugClass(@PathVariable Long id) {
        try {
            drugClassSevice.deleteDrugClass(id);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }

    @GetMapping("/drug-class/detail/{id}")
    public ResponseEntity<?> getDrugClassDetail(@PathVariable Long id) {
        try {
            DrugClassDTO dto = drugClassSevice.findDrugClassById(id);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }


}
