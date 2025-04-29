package com.mentos74.drugsapp.web.service.impl;

import com.mentos74.drugsapp.web.dto.DrugClassCreateRequestDTO;
import com.mentos74.drugsapp.web.dto.DrugClassResponseRequestDTO;
import com.mentos74.drugsapp.web.dto.DrugClassUpdateRequestDTO;
import com.mentos74.drugsapp.web.entity.DrugClass;
import com.mentos74.drugsapp.web.repository.DrugClassRepository;
import com.mentos74.drugsapp.web.service.DrugClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DrugClassServiceImpl implements DrugClassService {

    @Autowired
    DrugClassRepository drugClassRepository;

    @Override
    public void createDrugClass(DrugClassCreateRequestDTO dto) {
        DrugClass drugClass = new DrugClass();
        drugClass.setDrugClassName(dto.getDrugClassName());
        drugClass.setDrugClassDescription(dto.getDrugClassDescription());
        drugClass.setDeleted(false);
        drugClass.prePersist();

        drugClassRepository.save(drugClass);
    }

    @Override
    public void updateDrugClass(DrugClassUpdateRequestDTO dto, Long id) {

        DrugClass drugClass = drugClassRepository.findById(id).orElseThrow();
        drugClass.setDrugClassName(dto.getDrugClassName());
        drugClass.setDrugClassDescription(dto.getDrugClassDescription());
        drugClass.preUpdate();

        drugClassRepository.save(drugClass);
    }

    @Override
    public void deleteDrugClass(Long id) {
        DrugClass drugClass = drugClassRepository.findById(id).orElseThrow();
        drugClass.setDeleted(true);
        drugClass.preUpdate();

        drugClassRepository.save(drugClass);

    }

    @Override
    public List<DrugClassResponseRequestDTO> listDrugClass() {
        return drugClassRepository.findByDeletedFalseOrderByUpdatedAtDesc().stream().map((c) -> {
                    DrugClassResponseRequestDTO dto = new DrugClassResponseRequestDTO();
                    dto.setDrugClassId(c.getDrugClassId());
                    dto.setDrugClassDescription(c.getDrugClassDescription());
                    dto.setDrugClassName(c.getDrugClassName());
                    dto.setDeleted(c.getDeleted());
                    return dto;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public DrugClassUpdateRequestDTO findDrugClassById(Long id) {

        DrugClass drugClass = drugClassRepository.findById(id).orElseThrow();
        DrugClassUpdateRequestDTO drugClassUpdateRequestDTO = new DrugClassUpdateRequestDTO();
        drugClassUpdateRequestDTO.setDeleted(drugClass.getDeleted());
        drugClassUpdateRequestDTO.setDrugClassDescription(drugClass.getDrugClassDescription());
        drugClassUpdateRequestDTO.setDrugClassName(drugClass.getDrugClassName());
        drugClassUpdateRequestDTO.setDrugClassId(drugClass.getDrugClassId());

        return drugClassUpdateRequestDTO;
    }


}
