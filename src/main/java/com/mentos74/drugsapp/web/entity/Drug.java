package com.mentos74.drugsapp.web.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.io.Serial;
import java.io.Serializable;

@Table(name = "drug")
@Entity
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Drug implements Serializable {

    @Serial
    private static final long serialVersionUID = 8457007351017104208L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long drugId;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "indication", columnDefinition = "text")
    private String indication;

    @Column(name = "contra_indication", columnDefinition = "text")
    private String contraIndication;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "text")
    private String drugPhoto;


    @ManyToMany
    @JoinTable(
            name = "drug_ingredients",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "active_ingredient_id")
    )
    private Set<ActiveIngredient> activeIngredients;


    @ManyToMany
    @JoinTable(
            name = "drug_classifications",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_class_id")
    )
    private Set<DrugClass> drugClasses;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleted;


    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
