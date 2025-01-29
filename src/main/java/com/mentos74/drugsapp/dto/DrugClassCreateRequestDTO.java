package com.mentos74.drugsapp.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DrugClassCreateRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6967786537451459087L;

    Long drugClassId;

    String drugClassName;

    String drugClassDescription;
}
