package com.mentos74.drugsapp.service;

import com.mentos74.drugsapp.dto.ActiveIngredientCreateRequestDTO;
import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;
import com.mentos74.drugsapp.dto.ActiveIngredientUpdateRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActiveIngredientService {

    public void createNewActiveIngredient(ActiveIngredientCreateRequestDTO dto);

    public void updateActiveIngredient(ActiveIngredientUpdateRequestDTO dto);

    public void deleteActiveIngredient(Long id);

    public List<ActiveIngredientResponseRequestDTO> listActiveIngredient();

    public CompanyUpdateRequestDTO findCompanyById(Long id);

}
