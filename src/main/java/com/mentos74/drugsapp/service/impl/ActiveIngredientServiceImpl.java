package com.mentos74.drugsapp.service.impl;

import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import com.mentos74.drugsapp.repository.ActiveINgredientRepository;
import com.mentos74.drugsapp.service.ActiveIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
        List<ActiveIngredientResponseRequestDTO> listResponse = activeINgredientRepository.findAll().stream().map((c) -> {
            ActiveIngredientResponseRequestDTO dto = new ActiveIngredientResponseRequestDTO();
            dto.setActiveIngredientId(c.getActiveIngredientId());
            dto.setNameActiveIngredient(c.getNameActiveIngredient());
            dto.setDescription(c.getDescription());
            dto.setChemicalFormula(c.getChemicalFormula());
            dto.setChemicalStructure(c.getChemicalStructure());
            return dto;
        }).collect(Collectors.toList());
        return listResponse;
    }

    @Override
    public CompanyUpdateRequestDTO findCompanyById(Long id) {
        return null;
    }
}
