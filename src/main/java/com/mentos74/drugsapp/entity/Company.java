package com.mentos74.drugsapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "company")
@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String companyName;

    String companyAddress;

    String companyEmail;

    String companyPhone;
}
