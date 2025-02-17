package com.mentos74.drugsapp.dto;

import com.mentos74.drugsapp.entity.ActiveIngredient;
import com.mentos74.drugsapp.entity.Company;
import com.mentos74.drugsapp.entity.DrugClass;
import lombok.Data;
import java.util.Set;

@Data
public class DrugResponseRequestDTO {

    private Long drugId;

    private String drugName;

    private String indication;

    private String contraIndication;

    private String description;

    private Set<Long> activeIngredients;

    private Set<Long> drugClasses;

    private Company company;

}
