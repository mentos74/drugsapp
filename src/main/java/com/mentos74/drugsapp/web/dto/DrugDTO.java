package com.mentos74.drugsapp.web.dto;

import com.mentos74.drugsapp.web.entity.Company;
import lombok.Data;

import java.util.Set;

@Data
public class DrugDTO {
    private Long drugId;

    private String drugName;

    private String indication;

    private String contraIndication;

    private String description;

    private Set<Long> activeIngredients;

    private Set<Long> drugClasses;

    private Company company;

    private String drugPhoto;

    private String drugPhotoUrl;
}
