package com.mentos74.drugsapp.web.service;


import com.mentos74.drugsapp.web.dto.*;
import com.mentos74.drugsapp.web.entity.Attachment;
import com.mentos74.drugsapp.web.entity.DrugClass;

import java.util.List;

public interface DrugService {

    public void createDrug(DrugDTO drugDTO, List<Long> activeIngredientIds, List<Long> drugClassIds,  Attachment attachment);

    public void updateDrug(DrugDTO drugDTO, List<Long> activeIngredientIds, List<Long> drugClassIds,  Attachment attachment);

    public List<DrugDTO> listDrugs();

    public DrugDTO findDrugById(Long id);

    public DrugDTO findDrugByIdApi(Long id);

    public void deleteDrug(Long id);

    public List<CompanyDTO> listCompany();

    public List<DrugClassDTO> listDrugClass();

    public List<ActiveIngredientDTO> listActiveIngredient();



}

