package com.mentos74.drugsapp.repository;

import com.mentos74.drugsapp.entity.Company;
import com.mentos74.drugsapp.entity.DrugClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugClassRepository extends JpaRepository<DrugClass,Long> {

    List<DrugClass> findByDeletedFalseOrderByUpdatedAtDesc();
}
