package com.mentos74.drugsapp.web.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CompanyDTO {

    private Long companyId;

    private String companyName;

    private String companyAddress;

    private String companyEmail;

    private String companyPhone;

    private String companyCountry;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
