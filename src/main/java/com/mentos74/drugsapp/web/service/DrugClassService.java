package com.mentos74.drugsapp.web.service;

import com.mentos74.drugsapp.web.dto.DrugClassCreateRequestDTO;
import com.mentos74.drugsapp.web.dto.DrugClassDTO;
import com.mentos74.drugsapp.web.dto.DrugClassResponseRequestDTO;
import com.mentos74.drugsapp.web.dto.DrugClassUpdateRequestDTO;

import java.util.List;

public interface DrugClassService {

    public void createDrugClass(DrugClassDTO dto);

    public void updateDrugClass(DrugClassDTO dto);

    public void deleteDrugClass(Long id);

    public List<DrugClassDTO> listDrugClass();

    public DrugClassDTO findDrugClassById(Long id);

}
