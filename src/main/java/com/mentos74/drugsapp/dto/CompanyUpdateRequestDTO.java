package com.mentos74.drugsapp.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CompanyUpdateRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7395484766189163865L;

    Long companyId;

    String companyName;

    String companyAddress;

    String companyEmail;

    String companyPhone;
}
