package com.mentos74.drugsapp.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Table(name = "drugs")
@Entity
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Drugs implements Serializable {

    @Serial
    private static final long serialVersionUID = 8457007351017104208L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name= "drugs_name")
    String drugsName;

    @Column(name= "indication" , columnDefinition = "text")
    String indication;

    @Column(name= "contra_indication", columnDefinition = "text")
    String contraIndication;

    @Column(name= "description" , columnDefinition = "text")
    String description;



//    @ElementCollection
//    @Column(name = "ingredients")
//    List<String> ingredients;

}
