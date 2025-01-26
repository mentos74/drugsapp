package com.mentos74.drugsapp.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Table(name = "active_ingredient")
@Data
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ActiveIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activeIngredientId;

    private String nameActiveIngredient;


    @Column(columnDefinition = "text")
    private String chemicalStructure;


    private String chemicalFormula;

    @Column(columnDefinition = "text")
    private String description;
}
