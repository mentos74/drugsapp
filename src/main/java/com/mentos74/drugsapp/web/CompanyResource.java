package com.mentos74.drugsapp.web;


import com.mentos74.drugsapp.dto.CompanyCreateRequestDTO;
import com.mentos74.drugsapp.dto.CompanyResponseRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import com.mentos74.drugsapp.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/company/edit/{id}")
    public String editNewPost(@PathVariable Long id, Model model) {
        CompanyUpdateRequestDTO companyUpdateRequestDTO = companyService.findCompanyById(id);
        model.addAttribute("companyUpdateRequestDTO", companyUpdateRequestDTO);
        return "/company/edit_company";
    }

    @PostMapping("/company/edit/{id}")
    public String updatePost(@PathVariable Long id,
                             @ModelAttribute("companyUpdateRequestDTO") @Valid CompanyUpdateRequestDTO companyUpdateRequestDTO,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("companyUpdateRequestDTO", companyUpdateRequestDTO);
            return "/company/edit_company";
        }

        companyService.updateCompany(companyUpdateRequestDTO, id);
        return "redirect:/company/list";
    }


    @GetMapping("/company/delete/{id}")
    public String deleteCompanyConfirmation(@PathVariable Long id, Model model) {

        CompanyUpdateRequestDTO companyUpdateRequestDTO = companyService.findCompanyById(id);
        model.addAttribute("companyUpdateRequestDTO", companyUpdateRequestDTO);
        return "/company/delete_company";
    }

    @PostMapping("/company/delete/{id}")
    public String deleteCompany(@PathVariable Long id,  Model model) {

        companyService.deleteCompany(id);
        return "redirect:/list";
    }


}
