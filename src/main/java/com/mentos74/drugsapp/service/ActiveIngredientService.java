package com.mentos74.drugsapp.service;

import com.mentos74.drugsapp.dto.ActiveIngredientRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActiveIngredientService {

    public void createNewActiveIngredient(ActiveIngredientRequestDTO dto);

    public void updateActiveIngredient(ActiveIngredientRequestDTO dto);

    public void deleteActiveIngredient(Long id);

    public List<ActiveIngredientRequestDTO> listActiveIngredient();

    public ActiveIngredientRequestDTO findActiveIngredientById(Long id);

}
