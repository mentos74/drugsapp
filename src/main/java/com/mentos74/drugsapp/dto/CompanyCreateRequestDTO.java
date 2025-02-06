package com.mentos74.drugsapp.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompanyCreateRequestDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = -2659293516029213903L;

    private String companyName;

    private String companyAddress;

    private String companyEmail;

    private String companyPhone;


}
