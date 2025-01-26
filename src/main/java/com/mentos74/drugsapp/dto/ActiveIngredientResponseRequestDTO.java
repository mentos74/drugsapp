package com.mentos74.drugsapp.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ActiveIngredientResponseRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -9200793757235711997L;

    private Long activeIngredientId;

    private String description;

    private String nameActiveIngredient;

    private String chemicalFormula;

    private MultipartFile chemicalStructure;

}
