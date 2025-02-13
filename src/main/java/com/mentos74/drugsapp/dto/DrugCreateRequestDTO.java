package com.mentos74.drugsapp.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DrugCreateRequestDTO {

    String drugName;
    String company;
    List<String> ingredients;
    String indication;
    String contraIndication;
    String description;


}
