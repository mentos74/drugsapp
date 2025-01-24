package com.mentos74.drugsapp.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ActiveIngredientCreateRequestDTO  implements Serializable {

    @Serial
    private static final long serialVersionUID = -5302843420498648938L;

    Long activeIngredientId;

    String description;

    String nameActiveIngredient;

    String chemicalFormula;

    String chemicalStructure;
}
