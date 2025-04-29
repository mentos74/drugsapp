package com.mentos74.drugsapp.web.controller;


import com.mentos74.drugsapp.web.dto.CompanyDTO;
import com.mentos74.drugsapp.web.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@Controller()
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/company/list")
    public String listCompany(Model model) {
        List<CompanyDTO> listCompany = companyService.listCompany();
        System.out.println("hehe >>"+ listCompany);
        model.addAttribute("listCompany", listCompany);
        return "/company/list_company";
    }

    @GetMapping("/company/detail/{id}")
    public ResponseEntity<?> getCompanyDetails(@PathVariable Long id) {
        CompanyDTO dto = companyService.findCompanyById(id);
        return ResponseEntity.ok().body(dto);
    }


    @PostMapping("/company/add")
    public ResponseEntity<?> addNewCompany(@ModelAttribute CompanyDTO dto) {
        try {
            System.out.println("hehe add>>"+dto);
            companyService.createNewCompany(dto);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }

    }

    @PostMapping("/company/edit")
    public ResponseEntity<?>  editCompany(@ModelAttribute CompanyDTO dto) {
        try {
            companyService.updateCompany(dto);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }

    @PostMapping("/company/delete/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
        try {
            companyService.deleteCompany(id);
            return ResponseEntity.ok(Collections.singletonMap("status", "success"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("status", "error"));
        }
    }


}
