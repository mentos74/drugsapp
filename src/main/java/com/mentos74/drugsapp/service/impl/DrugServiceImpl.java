package com.mentos74.drugsapp.service.impl;


import com.mentos74.drugsapp.dto.*;
import com.mentos74.drugsapp.entity.ActiveIngredient;
import com.mentos74.drugsapp.entity.Drug;
import com.mentos74.drugsapp.entity.DrugClass;
import com.mentos74.drugsapp.repository.ActiveIngredientRepository;
import com.mentos74.drugsapp.repository.CompanyRepository;
import com.mentos74.drugsapp.repository.DrugClassRepository;
import com.mentos74.drugsapp.repository.DrugRepository;
import com.mentos74.drugsapp.service.ActiveIngredientService;
import com.mentos74.drugsapp.service.CompanyService;
import com.mentos74.drugsapp.service.DrugService;
import com.mentos74.drugsapp.service.DrugClassService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class DrugServiceImpl implements DrugService {

    @Autowired
    DrugRepository drugRepository;

    @Autowired
    DrugClassRepository drugClassRepository;

    @Autowired
    ActiveIngredientRepository activeIngredientRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyService companyService;

    @Autowired
    DrugClassService drugClassService;

    @Autowired
    ActiveIngredientService activeIngredientService;



    @Override
    public void createDrug(DrugCreateRequestDTO drugCreateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId) {
        Drug drug = new Drug();
        drug.setDrugName(drugCreateRequestDTO.getDrugName());
        drug.setIndication(drugCreateRequestDTO.getIndication());
        drug.setContraIndication(drugCreateRequestDTO.getContraIndication());
        drug.setDescription(drugCreateRequestDTO.getDescription());
        drug.setDeleted(false);


        if (drugClassIds != null) {
            Set<DrugClass> selectedDrugClasses = drugClassRepository.findAllById(drugClassIds)
                    .stream()
                    .collect(Collectors.toSet());
            drug.setDrugClasses(selectedDrugClasses);
        } else {
            drug.setDrugClasses(new HashSet<>());
        }

        if (activeIngredientIds != null) {
            Set<ActiveIngredient> selectedActiveIngredients = activeIngredientRepository.findAllById(activeIngredientIds)
                    .stream()
                    .collect(Collectors.toSet());
            drug.setActiveIngredients(selectedActiveIngredients);
        } else {
            drug.setActiveIngredients(new HashSet<>());
        }


        drug.setCompany(companyRepository.findById(drugCreateRequestDTO.getCompany().getCompanyId()).orElse(null));
        drugRepository.save(drug);
    }

    @Override
    public void updateDrug(DrugUpdateRequestDTO drugUpdateRequestDTO, List<Long> activeIngredientIds, List<Long> drugClassIds, Long companyId) {

    }

    @Override
    public List<DrugResponseRequestDTO> listDrugs() {
        return drugRepository.findByDeletedFalseOrderByUpdatedAtDesc().stream().map((s)->{
            DrugResponseRequestDTO dto = new DrugResponseRequestDTO();
            dto.setDrugId(s.getDrugId());
            dto.setDrugName(s.getDrugName());
            dto.setCompany(s.getCompany());
            dto.setDescription(s.getDescription());
            dto.setIndication(s.getIndication());
            dto.setContraIndication(s.getContraIndication());

            dto.setActiveIngredients(
                    s.getActiveIngredients().stream()
                            .map(ActiveIngredient::getActiveIngredientId)
                            .collect(Collectors.toSet())
            );

            dto.setDrugClasses(
                    s.getDrugClasses().stream()
                            .map(DrugClass::getDrugClassId)
                            .collect(Collectors.toSet())
            );

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public DrugUpdateRequestDTO findDrugById(Long id) {

        Drug drug =  drugRepository.findById(id).orElseThrow();
        DrugUpdateRequestDTO dto = new DrugUpdateRequestDTO();

        dto.setDrugId(drug.getDrugId());
        dto.setDrugName(drug.getDrugName());
        dto.setCompany(drug.getCompany());
        dto.setDescription(drug.getDescription());
        dto.setIndication(drug.getIndication());
        dto.setContraIndication(drug.getContraIndication());

        dto.setActiveIngredients(
                drug.getActiveIngredients().stream()
                        .map(ActiveIngredient::getActiveIngredientId)
                        .collect(Collectors.toSet())
        );

        dto.setDrugClasses(
                drug.getDrugClasses().stream()
                        .map(DrugClass::getDrugClassId)
                        .collect(Collectors.toSet())
        );

        return dto;
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

    @Override
    public List<ActiveIngredientResponseRequestDTO> listActiveIngredient() {
        return activeIngredientService.listActiveIngredient();
    }
}
