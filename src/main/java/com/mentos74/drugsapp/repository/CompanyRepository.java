package com.mentos74.drugsapp.repository;

import com.mentos74.drugsapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByDeletedFalseOrderByUpdatedAtDesc();

}
