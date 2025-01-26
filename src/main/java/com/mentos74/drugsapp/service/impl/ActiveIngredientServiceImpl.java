package com.mentos74.drugsapp.service.impl;

import com.mentos74.drugsapp.dto.ActiveIngredientCreateRequestDTO;
import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;
import com.mentos74.drugsapp.dto.ActiveIngredientUpdateRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import com.mentos74.drugsapp.entity.ActiveIngredient;
import com.mentos74.drugsapp.repository.ActiveINgredientRepository;
import com.mentos74.drugsapp.service.ActiveIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActiveIngredientServiceImpl implements ActiveIngredientService {

    @Autowired
    ActiveINgredientRepository activeINgredientRepository;


    @Override
    public void createNewActiveIngredient(ActiveIngredientCreateRequestDTO dto) {

        ActiveIngredient api = new ActiveIngredient();
        api.setDescription(dto.getDescription());
        api.setNameActiveIngredient(dto.getNameActiveIngredient());
        api.setChemicalFormula(dto.getChemicalFormula());

        try {
            // Simpan file sebagai byte array ke database
            api.setChemicalStructure(dto.getChemicalStructure().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to process file", e);
        }


        activeINgredientRepository.save(api);
    }

    @Override
    public void updateActiveIngredient(ActiveIngredientUpdateRequestDTO dto) {

        ActiveIngredient api = activeINgredientRepository.findById(dto.getActiveIngredientId()).orElseThrow();
        api.setDescription(dto.getDescription());
        api.setNameActiveIngredient(dto.getNameActiveIngredient());
        api.setChemicalFormula(dto.getChemicalFormula());
//        api.setChemicalStructure(dto.getChemicalStructure().getBytes());

        activeINgredientRepository.save(api);

    }

    @Override
    public void deleteActiveIngredient(Long id) {

    }

    @Override
    public List<ActiveIngredientResponseRequestDTO> listActiveIngredient() {

        List<ActiveIngredientResponseRequestDTO> listResponse = activeINgredientRepository.findAll().stream().map((c) -> {
            ActiveIngredientResponseRequestDTO dto = new ActiveIngredientResponseRequestDTO();
            dto.setActiveIngredientId(c.getActiveIngredientId());
            dto.setNameActiveIngredient(c.getNameActiveIngredient());
            dto.setDescription(c.getDescription());
            dto.setChemicalFormula(c.getChemicalFormula());
//            dto.setChemicalStructure(c.getChemicalStructure());
            return dto;
        }).collect(Collectors.toList());
        return listResponse;
    }

    @Override
    public CompanyUpdateRequestDTO findCompanyById(Long id) {
        return null;
    }
}
