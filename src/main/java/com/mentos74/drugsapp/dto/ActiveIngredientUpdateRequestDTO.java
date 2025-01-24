package com.mentos74.drugsapp.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ActiveIngredientUpdateRequestDTO {
    Long activeIngredientId;
    String description;
    String nameActiveIngredient;
    String chemicalFormula;
    String chemicalStructure;
}
