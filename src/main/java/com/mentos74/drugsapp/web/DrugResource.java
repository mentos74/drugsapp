package com.mentos74.drugsapp.web;

import com.mentos74.drugsapp.dto.DrugCreateRequestDTO;
import com.mentos74.drugsapp.dto.DrugResponseRequestDTO;
import com.mentos74.drugsapp.dto.DrugUpdateRequestDTO;
import com.mentos74.drugsapp.service.DrugService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

//todo tambahin gambar di drug.java nya, bikin juga service buat drugsnya

@Controller
public class DrugResource {

    @Autowired
    DrugService drugService;

    @GetMapping("/drug/list")
    public String listDrug(Model model) {
        List<DrugResponseRequestDTO> listDrugs = drugService.listDrugs();
        System.out.println("bjir>>"+listDrugs.size());
        model.addAttribute("listDrugs", listDrugs);
        return "/drug/list_drug";
    }


    @GetMapping("/drug/add")
    public String addDrug(Model model) {
        DrugCreateRequestDTO dto = new DrugCreateRequestDTO();
        dto.setDrugClasses(Collections.emptySet());
        dto.setActiveIngredients(Collections.emptySet());
        model.addAttribute("companies", drugService.listCompany());
        model.addAttribute("drugClasses", drugService.listDrugClass());
        model.addAttribute("activeIngredients", drugService.listActiveIngredient());
        model.addAttribute("dto", dto);
        return "/drug/add_drug";
    }


    @PostMapping("/drug/add")
    public String addNewDrug(@ModelAttribute("dto") @Valid DrugCreateRequestDTO dto,
                             @RequestParam(value = "activeIngredients", required = false) List<Long> activeIngredientIds,
                             @RequestParam(value = "drugClasses", required = false) List<Long> drugClassIds,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dto", dto);
            return "/drug/add_drug";
        }
        drugService.createDrug(dto, activeIngredientIds, drugClassIds, dto.getCompany().getCompanyId());
        return "redirect:/drug/list";
    }

    @GetMapping("/drug/edit/{id}")
    public String editDrugNew(@PathVariable Long id, Model model) {
        DrugUpdateRequestDTO dto = drugService.findDrugById(id);
        model.addAttribute("dto", dto);
        model.addAttribute("companies", drugService.listCompany());
        model.addAttribute("drugClasses", drugService.listDrugClass());
        model.addAttribute("activeIngredients", drugService.listActiveIngredient());
        return "/drug/edit_drug";
    }

    @PostMapping("/drug/edit/{id}")
    public String editDrug(@PathVariable Long id,
                              @ModelAttribute("dto") @Valid DrugUpdateRequestDTO dto,
                              @RequestParam(value = "activeIngredients", required = false) List<Long> activeIngredientIds,
                              @RequestParam(value = "drugClasses", required = false) List<Long> drugClassIds,
                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dto", dto);
            model.addAttribute("companies", dto.getCompany());
            model.addAttribute("drugClasses", drugClassIds);
            model.addAttribute("activeIngredients", activeIngredientIds);
            return "/drug/edit_drug";
        }

        drugService.updateDrug(dto, activeIngredientIds, drugClassIds, dto.getCompany().getCompanyId());
        return "redirect:/drug/list";
    }


    @PostMapping("/drug/delete/{id}")
    public String deleteDrug(@PathVariable Long id) {
        drugService.deleteDrug(id);
        return "redirect:/drug/list";
    }


}
