package com.mentos74.drugsapp.repository;

import com.mentos74.drugsapp.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long> {
    List<Drug> findByDeletedFalseOrderByUpdatedAtDesc();
}
