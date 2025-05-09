package com.mentos74.drugsapp.web.dto;


import com.mentos74.drugsapp.web.entity.Attachment;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class ActiveIngredientDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -9200793757235711997L;

    private Long activeIngredientId;

    private String description;

    @NotBlank(message = "Name is required")
    private String nameActiveIngredient;

    private String chemicalFormula;

    private Boolean deleted;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long chemicalStructureId;

    private String chemicalStructureFileName;

    private String chemicalStructureUrl;
}
