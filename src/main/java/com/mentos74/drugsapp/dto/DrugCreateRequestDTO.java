package com.mentos74.drugsapp.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mentos74.drugsapp.entity.Company;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DrugCreateRequestDTO {

    private String drugName;

    private String indication;

    private String contraIndication;

    private String description;

    private Set<Long> activeIngredients;

    private Set<Long> drugClasses;

    private Company company;


}
