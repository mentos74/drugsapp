package com.mentos74.drugsapp.web;


import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;
import com.mentos74.drugsapp.service.ActiveIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class IngredientActiveResource {

    @Autowired
    ActiveIngredientService activeIngredientService;

    public String listActiveIngredients() {

        List<ActiveIngredientResponseRequestDTO> listAI = activeIngredientService.listActiveIngredient();

        return ("/ActiveIngredient/list_activeIngredient");
    }


}
