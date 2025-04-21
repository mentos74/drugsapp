package com.mentos74.drugsapp.service;


import com.mentos74.drugsapp.dto.*;

import java.util.List;

public interface DrugService {

    public void createDrug(DrugCreateRequestDTO drugCreateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId);

    public void updateDrug(DrugUpdateRequestDTO drugUpdateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId);

    public List<DrugResponseRequestDTO> listDrugs();

    public DrugUpdateRequestDTO findDrugById(Long id);

    public DrugResponseRequestDTO findDrugByIdApi(Long id);

    public void deleteDrug(Long id);

    public List<CompanyResponseRequestDTO> listCompany();

    public List<DrugClassResponseRequestDTO> listDrugClass();

    public List<ActiveIngredientDTO> listActiveIngredient();



}

