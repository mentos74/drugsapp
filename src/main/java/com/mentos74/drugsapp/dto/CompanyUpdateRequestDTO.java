package com.mentos74.drugsapp.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompanyUpdateRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7395484766189163865L;

    private Long companyId;

    private String companyName;

    private String companyAddress;

    private String companyEmail;

    private String companyPhone;

    private Boolean deleted;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
