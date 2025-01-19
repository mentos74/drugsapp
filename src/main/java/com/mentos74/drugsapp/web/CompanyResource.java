package com.mentos74.drugsapp.web;


import com.mentos74.drugsapp.dto.CompanyCreateRequestDTO;
import com.mentos74.drugsapp.dto.CompanyResponseRequestDTO;
import com.mentos74.drugsapp.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller()
public class CompanyResource {

    @Autowired
    CompanyService companyService;


    @GetMapping("/company/list")
    public String listCompany(Model model) {
        List<CompanyResponseRequestDTO> listCompany = companyService.listCompany();
        model.addAttribute("listCompany", listCompany);
        return "/company/list_company";
    }


    @GetMapping("/company/add")
    public String addCompany(Model model) {
        CompanyCreateRequestDTO companyCreateRequestDTO = new CompanyCreateRequestDTO();
        model.addAttribute("companyCreateRequestDTO", companyCreateRequestDTO);
        return "/company/add_company";
    }

    @PostMapping("/company/add")
    public String addNewCompany(@ModelAttribute("companyCreateRequestDTO") @Valid CompanyCreateRequestDTO companyCreateRequestDTO,
                                BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("companyCreateRequestDTO", companyCreateRequestDTO);
            return "/company/add_company";
        }
        companyService.createNewCompany(companyCreateRequestDTO);
        return "redirect:/company/list";
    }


}
