package com.mentos74.drugsapp.web;

import com.mentos74.drugsapp.dto.DrugClassCreateRequestDTO;
import com.mentos74.drugsapp.dto.DrugClassResponseRequestDTO;
import com.mentos74.drugsapp.dto.DrugClassUpdateRequestDTO;
import com.mentos74.drugsapp.service.DrugClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DrugClassController {

    @Autowired
    DrugClassService drugClassSevice;


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


    @GetMapping("/drug-class/edit/{id}")
    public String editDrugClass(@PathVariable Long id, Model model) {
        //todo fix updatenya cuy
        DrugClassUpdateRequestDTO drugClassUpdateRequestDTO = drugClassSevice.findDrugClassById(id);
        model.addAttribute("dto", drugClassUpdateRequestDTO);
        return "/drug_class/edit_drugClass";
    }

    @PostMapping("/drug-class/edit/{id}")
    public String editDrugClassNew(@PathVariable Long id,
                             @ModelAttribute("dto") @Valid DrugClassUpdateRequestDTO drugClassUpdateRequestDTO,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dto", drugClassUpdateRequestDTO);
            return "/drug_class/edit_drugClass";
        }

        drugClassSevice.updateDrugClass(drugClassUpdateRequestDTO, id);
        return "redirect:/drug-class/list";
    }


    @PostMapping("/drug-class/delete/{id}")
    public String deleteDrugClass(@PathVariable Long id) {
        drugClassSevice.deleteDrugClass(id);
        return "redirect:/drug-class/list";
    }


}
