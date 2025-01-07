package com.mentos74.drugsapp.service;

import com.mentos74.drugsapp.entity.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugsService extends JpaRepository<Drugs, Long> {
}
