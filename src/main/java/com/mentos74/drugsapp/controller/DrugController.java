package com.mentos74.drugsapp.controller;

import com.mentos74.drugsapp.dto.DrugCreateRequestDTO;
import com.mentos74.drugsapp.dto.DrugUpdateRequestDTO;
import com.mentos74.drugsapp.entity.Drug;
import com.mentos74.drugsapp.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DrugController {

    @Autowired
    DrugService drugService;

    @GetMapping("/v1/drug")
    public ResponseEntity<String> getDrug() {
        String repsonse = "Hello guys";
        return ResponseEntity.ok(repsonse);
    }

    @PostMapping("/v1/drug")
    public ResponseEntity<DrugCreateRequestDTO> createDrug(@RequestBody DrugCreateRequestDTO dto) {

        Drug drug = new Drug();
        drug.setDrugName(dto.getDrugName());
        drug.setDescription(dto.getDescription());
        drug.setIndication(dto.getIndication());
        drug.setContraIndication(dto.getContraIndication());
//        drugService.save(drug);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/drug/{id}")
    public ResponseEntity<Long> deleteDrug(@PathVariable Long id) {
//        drugService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/v1/drug/{id}")
    public ResponseEntity<DrugUpdateRequestDTO> updateDrug(@RequestBody DrugUpdateRequestDTO dto, @PathVariable Long id) {

//        Drug drug =  drugService.findById(id).orElseThrow();
//
//        drug.setDrugName(dto.getDrugName());
//        drug.setDescription(dto.getDescription());
//        drug.setIndication(dto.getIndication());
//        drug.setContraIndication(dto.getContraIndication());

//        drugService.save(drug);

        return ResponseEntity.ok().build();
    }


}
