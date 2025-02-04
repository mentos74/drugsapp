package com.mentos74.drugsapp.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompanyResponseRequestDTO implements Serializable {
    
    @Serial
    private static final long serialVersionUID = -4250872747730385397L;

    Long companyId;

    String companyName;

    String companyAddress;

    String companyEmail;

    String companyPhone;

    LocalDateTime createdAt;

    LocalDateTime modifiedAt;
}
