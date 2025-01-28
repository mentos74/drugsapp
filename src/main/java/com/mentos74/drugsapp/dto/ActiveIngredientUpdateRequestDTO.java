package com.mentos74.drugsapp.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ActiveIngredientUpdateRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -4656118856882593178L;

    private Long activeIngredientId;

    private String description;

    private String nameActiveIngredient;

    private String chemicalFormula;

    private String chemicalStructure;
}
