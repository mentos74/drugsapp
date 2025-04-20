package com.mentos74.drugsapp.service.impl;

import com.mentos74.drugsapp.dto.ActiveIngredientRequestDTO;
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
    public void createNewActiveIngredient(ActiveIngredientRequestDTO dto) {

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
    public void updateActiveIngredient(ActiveIngredientRequestDTO dto) {

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
    public List<ActiveIngredientRequestDTO> listActiveIngredient() {

        return activeINgredientRepository.findByDeletedFalseOrderByUpdatedAtDesc().stream().map((c) -> {
            ActiveIngredientRequestDTO dto = new ActiveIngredientRequestDTO();
            dto.setActiveIngredientId(c.getActiveIngredientId());
            dto.setNameActiveIngredient(c.getNameActiveIngredient());
            dto.setDescription(c.getDescription());
            dto.setChemicalFormula(c.getChemicalFormula());
            dto.setChemicalStructure(c.getChemicalStructure());

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ActiveIngredientRequestDTO findActiveIngredientById(Long id) {
        ActiveIngredient activeIngredient =  activeINgredientRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("id not found"));

        ActiveIngredientRequestDTO dto = new ActiveIngredientRequestDTO();
        dto.setActiveIngredientId(activeIngredient.getActiveIngredientId());
        dto.setDescription(activeIngredient.getDescription());
        dto.setNameActiveIngredient(activeIngredient.getNameActiveIngredient());
        dto.setChemicalFormula(activeIngredient.getChemicalFormula());
        dto.setChemicalStructure(activeIngredient.getChemicalStructure());

        return dto;
    }


}
