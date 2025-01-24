package com.mentos74.drugsapp.service;

import com.mentos74.drugsapp.dto.ActiveIngredientResponseRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActiveIngredientService {

    public void createNewActiveIngredient();

    public void updateActiveIngredient();

    public void deleteActiveIngredient();

    public List<ActiveIngredientResponseRequestDTO> listActiveIngredient();

    public CompanyUpdateRequestDTO findCompanyById(Long id);

}
