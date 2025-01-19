package com.mentos74.drugsapp.service.impl;

import com.mentos74.drugsapp.dto.CompanyCreateRequestDTO;
import com.mentos74.drugsapp.dto.CompanyResponseRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import com.mentos74.drugsapp.entity.Company;
import com.mentos74.drugsapp.repository.CompanyRepository;
import com.mentos74.drugsapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void createNewCompany(CompanyCreateRequestDTO dto) {
        Company company = new Company();
        company.setCompanyName(dto.getCompanyName());
        company.setCompanyEmail(dto.getCompanyEmail());
        company.setCompanyAddress(dto.getCompanyAddress());
        company.setCompanyPhone(dto.getCompanyPhone());

        companyRepository.save(company);
    }

    @Override
    public void updateCompany(CompanyUpdateRequestDTO dto) {
        Company company = new Company();
        company.setCompanyName(dto.getCompanyName());
        company.setCompanyEmail(dto.getCompanyEmail());
        company.setCompanyAddress(dto.getCompanyAddress());
        company.setCompanyPhone(dto.getCompanyPhone());

        companyRepository.save(company);
    }

    @Override
    public List<CompanyResponseRequestDTO> listCompany() {
        return companyRepository.findAll().stream().map((c) -> {
            CompanyResponseRequestDTO dto = new CompanyResponseRequestDTO();
            dto.setCompanyAddress(c.getCompanyAddress());
            dto.setCompanyEmail(c.getCompanyEmail());
            dto.setCompanyPhone(c.getCompanyPhone());
            dto.setCompanyName(c.getCompanyName());
            return dto;

        }).collect(Collectors.toList());
    }
}
