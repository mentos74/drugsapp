package com.mentos74.drugsapp.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompanyUpdateRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7395484766189163865L;

    Long companyId;

    String companyName;

    String companyAddress;

    String companyEmail;

    String companyPhone;
}
