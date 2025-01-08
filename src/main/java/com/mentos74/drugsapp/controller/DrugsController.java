package com.mentos74.drugsapp.controller;

import com.mentos74.drugsapp.dto.DrugsCreateRequestDTO;
import com.mentos74.drugsapp.dto.DrugsUpdateRequestDTO;
import com.mentos74.drugsapp.entity.Drugs;
import com.mentos74.drugsapp.service.DrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DrugsController {

    @Autowired
    DrugsService drugsService;

    @GetMapping("/v1/drugs")
    public ResponseEntity<String> getDrugs() {
        String repsonse = "Hello guys";
        return ResponseEntity.ok(repsonse);
    }

    @PostMapping("/v1/drugs")
    public ResponseEntity<DrugsCreateRequestDTO> createDrugs(@RequestBody DrugsCreateRequestDTO dto) {

        Drugs drugs = new Drugs();
        drugs.setDrugsName(dto.getDrugsName());
        drugs.setDescription(dto.getDescription());
        drugs.setIndication(dto.getIndication());
        drugs.setContraIndication(dto.getContraIndication());
//        drugsService.save(drugs);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/drugs/{id}")
    public ResponseEntity<Long> deleteDrugs(@PathVariable Long id) {
//        drugsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/v1/drugs/{id}")
    public ResponseEntity<DrugsUpdateRequestDTO> updateDrugs(@RequestBody DrugsUpdateRequestDTO dto, @PathVariable Long id) {

//        Drugs drugs =  drugsService.findById(id).orElseThrow();
//
//        drugs.setDrugsName(dto.getDrugsName());
//        drugs.setDescription(dto.getDescription());
//        drugs.setIndication(dto.getIndication());
//        drugs.setContraIndication(dto.getContraIndication());

//        drugsService.save(drugs);

        return ResponseEntity.ok().build();
    }


}
