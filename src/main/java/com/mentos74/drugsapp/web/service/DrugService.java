package com.mentos74.drugsapp.web.service;


import com.mentos74.drugsapp.web.dto.*;
import com.mentos74.drugsapp.web.entity.DrugClass;

import java.util.List;

public interface DrugService {

    public void createDrug(DrugCreateRequestDTO drugCreateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId);

    public void updateDrug(DrugUpdateRequestDTO drugUpdateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId);

    public List<DrugResponseRequestDTO> listDrugs();

    public DrugUpdateRequestDTO findDrugById(Long id);

    public DrugResponseRequestDTO findDrugByIdApi(Long id);

    public void deleteDrug(Long id);

    public List<CompanyDTO> listCompany();

    public List<DrugClassDTO> listDrugClass();

    public List<ActiveIngredientDTO> listActiveIngredient();



}

