package com.mentos74.drugsapp.service.impl;

import com.mentos74.drugsapp.dto.DrugClassCreateRequestDTO;
import com.mentos74.drugsapp.dto.DrugClassResponseRequestDTO;
import com.mentos74.drugsapp.dto.DrugClassUpdateRequestDTO;
import com.mentos74.drugsapp.repository.DrugClassRepository;
import com.mentos74.drugsapp.service.DrugClassSevice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DrugClassServiceImpl implements DrugClassSevice {

    @Autowired
    DrugClassRepository drugClassRepository;

    @Override
    public void createDrugClass(DrugClassCreateRequestDTO dto) {

    }

    @Override
    public void updateDrugClass(DrugClassUpdateRequestDTO dto, Long id) {

    }

    @Override
    public void deleteDrugClass(Long id) {

    }

    @Override
    public List<DrugClassResponseRequestDTO> listDrugClass() {
        return drugClassRepository.findAll().stream().map((c) -> {
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
    public DrugClassUpdateRequestDTO findCompanyById(Long id) {
        return null;
    }
}
