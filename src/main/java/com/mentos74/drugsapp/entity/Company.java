package com.mentos74.drugsapp.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "company")
@Data
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long companyId;

    String companyName;

    String companyAddress;

    String companyEmail;

    String companyPhone;
}
