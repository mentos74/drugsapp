package com.mentos74.drugsapp.web;

import com.mentos74.drugsapp.dto.DrugCreateRequestDTO;
import com.mentos74.drugsapp.dto.DrugResponseRequestDTO;
import com.mentos74.drugsapp.service.DrugService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DrugResource {

    @Autowired
    DrugService drugService;

    @GetMapping("/drug/list")
    public String listDrug(Model model) {
        List<DrugResponseRequestDTO> listDrugs = drugService.listDrugs();
        model.addAttribute("listDrugs", listDrugs);
        return "/drug/list_drug";
    }


    @GetMapping("/drug/add")
    public String addDrug(Model model) {
        DrugCreateRequestDTO dto = new DrugCreateRequestDTO();
        model.addAttribute("companies", drugService.listCompany());
        model.addAttribute("drugClasses", drugService.listDrugClass());
        model.addAttribute("dto", dto);
        return "/drug/add_drug";
    }

    @PostMapping("/drug/add")
    public String addNewDrug(@ModelAttribute("dto") @Valid DrugCreateRequestDTO dto,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dto", dto);
            return "/drug/add_drug";
        }
        drugService.createDrug(dto,null,null,null);
        return "redirect:/drug/list";
    }

}
