package com.mentos74.drugsapp.service;

import com.mentos74.drugsapp.dto.DrugClassCreateRequestDTO;
import com.mentos74.drugsapp.dto.DrugClassResponseRequestDTO;
import com.mentos74.drugsapp.dto.DrugClassUpdateRequestDTO;
import com.mentos74.drugsapp.entity.DrugClass;

import java.util.List;

public interface DrugClassSevice {

    public void createDrugClass(DrugClassCreateRequestDTO dto);

    public void updateDrugClass(DrugClassUpdateRequestDTO dto, Long id);

    public void deleteDrugClass(Long id);

    public List<DrugClassResponseRequestDTO> listDrugClass();

    public DrugClassUpdateRequestDTO findDrugClassById(Long id);

}
