package com.mentos74.drugsapp.service.impl;

import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import com.mentos74.drugsapp.repository.ActiveINgredientRepository;
import com.mentos74.drugsapp.service.ActiveIngredientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ActiveIngredientServiceImpl implements ActiveIngredientService {

    @Autowired
    ActiveINgredientRepository activeINgredientRepository;

    @Override
    public void createNewActiveIngredient() {

    }

    @Override
    public void updateActiveIngredient() {

    }

    @Override
    public void deleteActiveIngredient() {

    }

    @Override
    public List<ActiveIngredientResponseRequestDTO> listActiveIngredient() {
        return List.of();
    }

    @Override
    public CompanyUpdateRequestDTO findCompanyById(Long id) {
        return null;
    }
}
