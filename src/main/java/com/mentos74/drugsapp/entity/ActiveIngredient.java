package com.mentos74.drugsapp.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "active_ingredient")
@Data
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ActiveIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long activeIngredientId;

    String nameActiveIngredient;

    String chemicalStructure;

    String chemicalFormula;

    String description;
}
