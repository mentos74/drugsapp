package com.mentos74.drugsapp.service.impl;

import com.mentos74.drugsapp.dto.CompanyCreateRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import com.mentos74.drugsapp.entity.Company;
import com.mentos74.drugsapp.repository.CompanyRepository;
import com.mentos74.drugsapp.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

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
}
