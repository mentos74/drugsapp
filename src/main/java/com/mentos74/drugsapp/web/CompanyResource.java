package com.mentos74.drugsapp.web;


import com.mentos74.drugsapp.dto.CompanyCreateRequestDTO;
import com.mentos74.drugsapp.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller()
public class CompanyResource {

    CompanyService companyService;

    @GetMapping("company/add")
    public String addCompany(Model model) {
        CompanyCreateRequestDTO companyCreateRequestDTO = new CompanyCreateRequestDTO();
        model.addAttribute("companyCreateRequestDTO", companyCreateRequestDTO);
        return "company/add_company";
    }

    @PostMapping("company/add")
    public String addNewCompany(@ModelAttribute("companyCreateRequestDTO") @Valid CompanyCreateRequestDTO companyCreateRequestDTO,
                                Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("companyCreateRequestDTO", companyCreateRequestDTO);
            return "/company/add_company";
        }
        companyService.createNewCompany(companyCreateRequestDTO);
        return "company/add_company";
    }


}
