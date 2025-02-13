package com.mentos74.drugsapp.service;


import com.mentos74.drugsapp.dto.DrugResponseRequestDTO;
import com.mentos74.drugsapp.dto.DrugUpdateRequestDTO;
import com.mentos74.drugsapp.entity.Drug;

import java.util.List;

public interface DrugService {

    public void createDrug(Drug drug, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId);

    public void updateDrug(Drug drug, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId);

    public List<DrugResponseRequestDTO> listCompany();

    public DrugUpdateRequestDTO findById();

    public void deleteDrug(Long id);

}

