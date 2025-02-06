package com.mentos74.drugsapp.entity;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "drug_class")
@Data
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DrugClass  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugClassId;

    private String drugClassName;

    private String drugClassDescription;


}
