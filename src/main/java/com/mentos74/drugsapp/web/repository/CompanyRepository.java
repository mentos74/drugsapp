package com.mentos74.drugsapp.web.repository;

import com.mentos74.drugsapp.web.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findByDeletedFalseOrderByUpdatedAtDesc();

}
