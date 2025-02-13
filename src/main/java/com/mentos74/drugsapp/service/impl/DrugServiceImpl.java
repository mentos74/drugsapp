package com.mentos74.drugsapp.service.impl;


import com.mentos74.drugsapp.dto.DrugCreateRequestDTO;
import com.mentos74.drugsapp.dto.DrugResponseRequestDTO;
import com.mentos74.drugsapp.dto.DrugUpdateRequestDTO;
import com.mentos74.drugsapp.entity.Drug;
import com.mentos74.drugsapp.service.DrugService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class DrugServiceImpl implements DrugService {


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
}
