package com.mentos74.drugsapp.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CompanyResponseRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -4250872747730385397L;
    String companyName;

    String companyAddress;

    String companyEmail;

    String companyPhone;
}
