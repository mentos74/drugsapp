package com.mentos74.drugsapp.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "active_ingredient")
@Data
public class ActiveIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long activeIngredientId;
    String nameActiveIngredient;
    String chemicalStructure;
    String chemicalFormula;
    String description;
}
