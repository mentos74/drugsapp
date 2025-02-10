package com.mentos74.drugsapp.web;

import com.mentos74.drugsapp.dto.DrugClassCreateRequestDTO;
import com.mentos74.drugsapp.dto.DrugClassResponseRequestDTO;
import com.mentos74.drugsapp.service.DrugClassSevice;
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
public class DrugClassResource {

    @Autowired
    DrugClassSevice drugClassSevice;


    @GetMapping("/drug-class/list")
    public String listDrugClass(Model model) {

        List<DrugClassResponseRequestDTO> listDrugClass = drugClassSevice.listDrugClass();
        model.addAttribute("dtos", listDrugClass);

        return "/drug_class/list_drugClass";
    }

    @GetMapping("drug-class/add")
    public String addDrugClass(Model model) {
        DrugClassCreateRequestDTO dto = new DrugClassCreateRequestDTO();
        model.addAttribute("dto", dto);
        return "/drug_class/add_drugClass";
    }

    @PostMapping("drug-class/add")
    public String addDrugClassNew(@ModelAttribute("dto") @Valid DrugClassCreateRequestDTO dto,
                                  BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("dto", dto);
            return "/drug_class/add_drugClass";
        }

        drugClassSevice.createDrugClass(dto);

        return "redirect:/drug-class/list";
    }


}
