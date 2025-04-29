package com.mentos74.drugsapp.web.repository;

import com.mentos74.drugsapp.web.entity.DrugClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugClassRepository extends JpaRepository<DrugClass,Long> {

    List<DrugClass> findByDeletedFalseOrderByUpdatedAtDesc();
}
