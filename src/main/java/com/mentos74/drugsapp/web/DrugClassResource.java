package com.mentos74.drugsapp.web;

import com.mentos74.drugsapp.dto.DrugClassResponseRequestDTO;
import com.mentos74.drugsapp.service.DrugClassSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class DrugClassResource {

    @Autowired
    DrugClassSevice drugClassSevice;



    @PostMapping("/drug-class/list")
    public String listDrugClass(Model model){
        List <DrugClassResponseRequestDTO> listDrugClass = drugClassSevice.listDrugClass();
        model.addAttribute("dto", listDrugClass);

        return "/drug-class/list_drugClass";
    }
}
