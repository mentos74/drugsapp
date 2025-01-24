package com.mentos74.drugsapp.web;


import com.mentos74.drugsapp.dto.ActiveIngredientCreateRequestDTO;
import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;
import com.mentos74.drugsapp.dto.ActiveIngredientUpdateRequestDTO;
import com.mentos74.drugsapp.service.ActiveIngredientService;
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
public class ActiveIngredientResource {

    @Autowired
    ActiveIngredientService activeIngredientService;

    @GetMapping("/active-ingredient/list")
    public String listActiveIngredients() {

        List<ActiveIngredientResponseRequestDTO> listAI = activeIngredientService.listActiveIngredient();

        return ("/ActiveIngredient/list_activeIngredient");
    }


    @GetMapping("/active-ingredient/add")
    public String addActiveIngredient(Model model) {
        ActiveIngredientCreateRequestDTO addActiveDTO = new ActiveIngredientCreateRequestDTO();
        model.addAttribute("dto", addActiveDTO);
        return ("/ActiveIngredient/add_activeIngredient");
    }


    @PostMapping("/active-ingredient/add")
    public String addActiveIngredientNew(@ModelAttribute("postUpdateRequestDTO") @Valid ActiveIngredientCreateRequestDTO addActiveDTO,
                                         BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("addActiveDTO", addActiveDTO);
            return "/ActiveIngredient/add_activeIngredient";
        }

        activeIngredientService.createNewActiveIngredient(addActiveDTO);
        return "redirect:/active-ingredient/list";
    }

}
