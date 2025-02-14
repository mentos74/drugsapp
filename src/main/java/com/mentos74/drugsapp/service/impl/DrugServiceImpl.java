package com.mentos74.drugsapp.service.impl;


import com.mentos74.drugsapp.dto.*;
import com.mentos74.drugsapp.repository.DrugRepository;
import com.mentos74.drugsapp.service.CompanyService;
import com.mentos74.drugsapp.service.DrugService;
import com.mentos74.drugsapp.service.DrugClassService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class DrugServiceImpl implements DrugService {

    @Autowired
    DrugRepository drugRepository;

    @Autowired
    CompanyService companyService;

    @Autowired
    DrugClassService drugClassService;


    //todo tambahin fungsi di service impl dan juga bikin fungsi
    // di drug resource sama jangan lupa di tambahin dan cek add edit listnya

    @Override
    public void createDrug(DrugCreateRequestDTO drugCreateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId) {

    }

    @Override
    public void updateDrug(DrugUpdateRequestDTO drugUpdateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId) {

    }

    @Override
    public List<DrugResponseRequestDTO> listDrugs() {
        return List.of();
    }

    @Override
    public DrugUpdateRequestDTO findById() {
        return null;
    }

    @Override
    public void deleteDrug(Long id) {

    }

    @Override
    public List<CompanyResponseRequestDTO> listCompany() {
        return companyService.listCompany();
    }

    @Override
    public List<DrugClassResponseRequestDTO> listDrugClass() {
        return drugClassService.listDrugClass();
    }
}
