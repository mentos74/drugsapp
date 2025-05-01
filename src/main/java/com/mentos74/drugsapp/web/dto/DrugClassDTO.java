package com.mentos74.drugsapp.web.dto;

import lombok.Data;

@Data
public class DrugClassDTO {

    private Long drugClassId;

    private String drugClassName;

    private String drugClassDescription;

    private Boolean deleted;

}
