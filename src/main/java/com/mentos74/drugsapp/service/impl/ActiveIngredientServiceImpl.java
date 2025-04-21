package com.mentos74.drugsapp.service.impl;

import com.mentos74.drugsapp.dto.ActiveIngredientDTO;
import com.mentos74.drugsapp.entity.ActiveIngredient;
import com.mentos74.drugsapp.repository.ActiveIngredientRepository;
import com.mentos74.drugsapp.service.ActiveIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActiveIngredientServiceImpl implements ActiveIngredientService {

    @Autowired
    ActiveIngredientRepository activeINgredientRepository;


    @Override
    public void createNewActiveIngredient(ActiveIngredientDTO dto) {

        ActiveIngredient api = new ActiveIngredient();
        api.setDescription(dto.getDescription());
        api.setNameActiveIngredient(dto.getNameActiveIngredient());
        api.setChemicalFormula(dto.getChemicalFormula());
        api.setChemicalStructure(dto.getChemicalStructure());
        api.setDeleted(false);
        api.prePersist();


        activeINgredientRepository.save(api);
    }

    @Override
    public void updateActiveIngredient(ActiveIngredientDTO dto) {

        ActiveIngredient api = activeINgredientRepository.findById(dto.getActiveIngredientId())
                .orElseThrow(() -> new RuntimeException("id not found"));
        api.setDescription(dto.getDescription() != null ? dto.getDescription() : api.getDescription());
        api.setNameActiveIngredient(dto.getNameActiveIngredient()!=null ? dto.getNameActiveIngredient(): api.getNameActiveIngredient());
        api.setChemicalFormula(dto.getChemicalFormula()!=null ? dto.getChemicalFormula() : api.getChemicalFormula());
        api.setChemicalStructure(dto.getChemicalStructure()!=null ? dto.getChemicalStructure() : api.getChemicalStructure());
        api.preUpdate();

        activeINgredientRepository.save(api);

    }

    @Override
    public void deleteActiveIngredient(Long id) {

        ActiveIngredient activeIngredient = activeINgredientRepository.findById(id).orElseThrow();
        activeIngredient.setDeleted(true);

        activeINgredientRepository.save(activeIngredient);

    }

    @Override
    public List<ActiveIngredientDTO> listActiveIngredient() {

        return activeINgredientRepository.findByDeletedFalseOrderByUpdatedAtDesc().stream().map((c) -> {
            ActiveIngredientDTO dto = new ActiveIngredientDTO();
            dto.setActiveIngredientId(c.getActiveIngredientId());
            dto.setNameActiveIngredient(c.getNameActiveIngredient());
            dto.setDescription(c.getDescription());
            dto.setChemicalFormula(c.getChemicalFormula());
            dto.setChemicalStructure(c.getChemicalStructure());

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ActiveIngredientDTO findActiveIngredientById(Long id) {
        ActiveIngredient activeIngredient =  activeINgredientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("id not found"));

        ActiveIngredientDTO dto = new ActiveIngredientDTO();
        dto.setActiveIngredientId(activeIngredient.getActiveIngredientId());
        dto.setDescription(activeIngredient.getDescription());
        dto.setNameActiveIngredient(activeIngredient.getNameActiveIngredient());
        dto.setChemicalFormula(activeIngredient.getChemicalFormula());
        dto.setChemicalStructure(activeIngredient.getChemicalStructure());

        return dto;
    }


}
