package com.mentos74.drugsapp.service.impl;

import com.mentos74.drugsapp.dto.DrusgsResponseDTO;
import com.mentos74.drugsapp.service.DrugsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DrugsServiceImpl implements DrugsService {

    private final DrugsService drugsService;

    @Override
    public DrusgsResponseDTO findById(String id) {
        return null;
    }
}
