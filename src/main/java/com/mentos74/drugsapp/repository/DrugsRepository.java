package com.mentos74.drugsapp.repository;

import com.mentos74.drugsapp.entity.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugsRepository extends JpaRepository<Drugs, Long> {
}
