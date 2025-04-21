package com.mentos74.drugsapp.service;

import com.mentos74.drugsapp.dto.ActiveIngredientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActiveIngredientService {

    public void createNewActiveIngredient(ActiveIngredientDTO dto);

    public void updateActiveIngredient(ActiveIngredientDTO dto);

    public void deleteActiveIngredient(Long id);

    public List<ActiveIngredientDTO> listActiveIngredient();

    public ActiveIngredientDTO findActiveIngredientById(Long id);

}
