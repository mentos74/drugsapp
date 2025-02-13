package com.mentos74.drugsapp.service;


import com.mentos74.drugsapp.dto.DrugCreateRequestDTO;
import com.mentos74.drugsapp.dto.DrugResponseRequestDTO;
import com.mentos74.drugsapp.dto.DrugUpdateRequestDTO;
import com.mentos74.drugsapp.entity.Drug;

import java.util.List;

public interface DrugService {

    public void createDrug(DrugCreateRequestDTO drugCreateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId);

    public void updateDrug(DrugUpdateRequestDTO drugUpdateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId);

    public List<DrugResponseRequestDTO> listDrugs();

    public DrugUpdateRequestDTO findById();

    public void deleteDrug(Long id);

}

