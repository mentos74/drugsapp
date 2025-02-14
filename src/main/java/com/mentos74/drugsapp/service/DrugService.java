package com.mentos74.drugsapp.service;


import com.mentos74.drugsapp.dto.*;
import com.mentos74.drugsapp.entity.Drug;

import java.util.List;

public interface DrugService {

    public void createDrug(DrugCreateRequestDTO drugCreateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId);

    public void updateDrug(DrugUpdateRequestDTO drugUpdateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId);

    public List<DrugResponseRequestDTO> listDrugs();

    public DrugUpdateRequestDTO findById();

    public void deleteDrug(Long id);

    public List<CompanyResponseRequestDTO> listCompany();

    public List<DrugClassResponseRequestDTO> listDrugClass();

    public List<ActiveIngredientResponseRequestDTO> listActiveIngredient();



}

