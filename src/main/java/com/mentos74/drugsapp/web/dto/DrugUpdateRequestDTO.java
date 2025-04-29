package com.mentos74.drugsapp.web.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mentos74.drugsapp.web.entity.Company;
import lombok.Data;

import java.util.Set;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DrugUpdateRequestDTO {

    private Long drugId;

    private String drugName;

    private String indication;

    private String contraIndication;

    private String description;

    private Set<Long> activeIngredients;

    private Set<Long> drugClasses;

    private Company company;

    private String drugPhoto;

}
