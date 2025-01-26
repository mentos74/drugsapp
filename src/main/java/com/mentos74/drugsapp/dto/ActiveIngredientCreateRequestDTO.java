package com.mentos74.drugsapp.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ActiveIngredientCreateRequestDTO  implements Serializable {

    @Serial
    private static final long serialVersionUID = -5302843420498648938L;

    private Long activeIngredientId;

    private String description;

    private String nameActiveIngredient;

    private String chemicalFormula;

    private String chemicalStructure;
}
