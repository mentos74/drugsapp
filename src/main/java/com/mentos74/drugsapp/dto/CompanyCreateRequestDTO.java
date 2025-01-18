package com.mentos74.drugsapp.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CompanyCreateRequestDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = -2659293516029213903L;

    String companyName;

    String companyAddress;

    String companyEmail;

    String companyPhone;




}
