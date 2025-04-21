package com.mentos74.drugsapp.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ActiveIngredientDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -9200793757235711997L;

    private Long activeIngredientId;

    private String description;

    @NotBlank(message = "Name is required")
    private String nameActiveIngredient;

    private String chemicalFormula;

    private String chemicalStructure;

    private Boolean deleted;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
