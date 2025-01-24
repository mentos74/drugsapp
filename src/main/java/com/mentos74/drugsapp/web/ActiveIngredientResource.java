package com.mentos74.drugsapp.web;


import com.mentos74.drugsapp.dto.ActiveIngredientCreateRequestDTO;
import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;
import com.mentos74.drugsapp.service.ActiveIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ActiveIngredientResource {

    @Autowired
    ActiveIngredientService activeIngredientService;

    @GetMapping("/active-ingredient/list")
    public String listActiveIngredients() {

        List<ActiveIngredientResponseRequestDTO> listAI = activeIngredientService.listActiveIngredient();

        return ("/ActiveIngredient/list_activeIngredient");
    }


    @GetMapping("/active-ingredient/add")
    public String addActiveIngredient (Model model){
        ActiveIngredientCreateRequestDTO addActiveDTO = new ActiveIngredientCreateRequestDTO();
        model.addAttribute("dto",addActiveDTO);
        return ("/ActiveIngredient/add_activeIngredient");
    }


}
