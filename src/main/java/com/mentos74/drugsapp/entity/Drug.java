package com.mentos74.drugsapp.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Data;
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
    Long drugId;

    @Column(name= "drug_name")
    String drugName;

    @Column(name= "indication" , columnDefinition = "text")
    String indication;

    @Column(name= "contra_indication", columnDefinition = "text")
    String contraIndication;

    @Column(name= "description" , columnDefinition = "text")
    String description;


    /** Relasi ke Active Ingredients (Many-to-Many) **/
    @ManyToMany
    @JoinTable(
            name = "drug_ingredients",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "active_ingredient_id")
    )
    private Set<ActiveIngredient> activeIngredients;

    /** Relasi ke Drug Class (Many-to-Many) **/
    @ManyToMany
    @JoinTable(
            name = "drug_classifications",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_class_id")
    )
    private Set<DrugClass> drugClasses;

    /** Relasi ke Company (Many-to-One) **/
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
