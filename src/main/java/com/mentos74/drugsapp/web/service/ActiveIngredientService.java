package com.mentos74.drugsapp.web.service;

import com.mentos74.drugsapp.web.dto.ActiveIngredientDTO;
import com.mentos74.drugsapp.web.entity.Attachment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActiveIngredientService {

    public void createNewActiveIngredient(ActiveIngredientDTO dto, Attachment attachment);

    public void updateActiveIngredient(ActiveIngredientDTO dto, Attachment attachment);

    public void deleteActiveIngredient(Long id);

    public List<ActiveIngredientDTO> listActiveIngredient();

    public ActiveIngredientDTO findActiveIngredientById(Long id);

}
