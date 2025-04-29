package com.mentos74.drugsapp.web.service.impl;

import com.mentos74.drugsapp.web.dto.ActiveIngredientDTO;
import com.mentos74.drugsapp.web.entity.ActiveIngredient;
import com.mentos74.drugsapp.web.entity.Attachment;
import com.mentos74.drugsapp.web.repository.ActiveIngredientRepository;
import com.mentos74.drugsapp.web.repository.AttachmentRepository;
import com.mentos74.drugsapp.web.service.ActiveIngredientService;
import com.mentos74.drugsapp.web.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActiveIngredientServiceImpl implements ActiveIngredientService {

    @Autowired
    ActiveIngredientRepository activeINgredientRepository;

    @Autowired
    AttachmentService attachmentService;


    @Override
    public void createNewActiveIngredient(ActiveIngredientDTO dto, Attachment attachment) {

        ActiveIngredient api = new ActiveIngredient();
        try {

            api.setDescription(dto.getDescription());
            api.setNameActiveIngredient(dto.getNameActiveIngredient());
            api.setChemicalFormula(dto.getChemicalFormula());
            if (attachment != null) {
                api.setChemicalStructure(attachment);
            }
            api.setDeleted(false);
            api.prePersist();

            activeINgredientRepository.save(api);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateActiveIngredient(ActiveIngredientDTO dto, Attachment attachment) {

        ActiveIngredient api = activeINgredientRepository.findById(dto.getActiveIngredientId())
                .orElseThrow(() -> new RuntimeException("id not found"));
        api.setDescription(dto.getDescription() != null ? dto.getDescription() : api.getDescription());
        api.setNameActiveIngredient(dto.getNameActiveIngredient() != null ? dto.getNameActiveIngredient() : api.getNameActiveIngredient());
        api.setChemicalFormula(dto.getChemicalFormula() != null ? dto.getChemicalFormula() : api.getChemicalFormula());
        api.setChemicalStructure(attachment != null ? attachment : api.getChemicalStructure());
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
            if (c.getChemicalStructure() != null) {
                dto.setChemicalStructureId(c.getChemicalStructure().getId());
                dto.setChemicalStructureFileName(Paths.get(c.getChemicalStructure().getFilePath()).getFileName().toString());
                dto.setChemicalStructureUrl("/api/attachment/view/" + dto.getChemicalStructureFileName());
            }

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ActiveIngredientDTO findActiveIngredientById(Long id) {
        ActiveIngredient activeIngredient = activeINgredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id not found"));

        ActiveIngredientDTO dto = new ActiveIngredientDTO();
        dto.setActiveIngredientId(activeIngredient.getActiveIngredientId());
        dto.setDescription(activeIngredient.getDescription());
        dto.setNameActiveIngredient(activeIngredient.getNameActiveIngredient());
        dto.setChemicalFormula(activeIngredient.getChemicalFormula());
        if (activeIngredient.getChemicalStructure() != null) {
            dto.setChemicalStructureId(activeIngredient.getChemicalStructure().getId());
            dto.setChemicalStructureFileName(Paths.get(activeIngredient.getChemicalStructure().getFilePath()).getFileName().toString());
            dto.setChemicalStructureUrl("/api/attachment/view/" + dto.getChemicalStructureFileName());
        }

        return dto;
    }


}
