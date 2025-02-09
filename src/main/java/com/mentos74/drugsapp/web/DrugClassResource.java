package com.mentos74.drugsapp.web;

import com.mentos74.drugsapp.dto.DrugClassResponseRequestDTO;
import com.mentos74.drugsapp.service.DrugClassSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DrugClassResource {

    @Autowired
    DrugClassSevice drugClassSevice;



    @GetMapping("/drug-class/list")
    public String listDrugClass(Model model){

        List <DrugClassResponseRequestDTO> listDrugClass = drugClassSevice.listDrugClass();
        model.addAttribute("dto", listDrugClass);

        return "/drug_class/list_drugClass";
    }
}
