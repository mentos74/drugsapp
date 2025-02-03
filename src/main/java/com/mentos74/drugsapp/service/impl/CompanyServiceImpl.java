package com.mentos74.drugsapp.service.impl;

import com.mentos74.drugsapp.dto.CompanyCreateRequestDTO;
import com.mentos74.drugsapp.dto.CompanyResponseRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import com.mentos74.drugsapp.entity.Company;
import com.mentos74.drugsapp.repository.CompanyRepository;
import com.mentos74.drugsapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void updateCompany(CompanyUpdateRequestDTO dto, Long id) {
        Company company = companyRepository.findById(id).orElseThrow();

        company.setCompanyName(dto.getCompanyName());
        company.setCompanyEmail(dto.getCompanyEmail());
        company.setCompanyAddress(dto.getCompanyAddress());
        company.setCompanyPhone(dto.getCompanyPhone());

        companyRepository.save(company);
    }

    @Override
    public List<CompanyResponseRequestDTO> listCompany() {
        return companyRepository.findByDeletedFalseOrderByCreatedAtDesc().stream().map((c) -> {
            CompanyResponseRequestDTO dto = new CompanyResponseRequestDTO();
            dto.setCompanyAddress(c.getCompanyAddress());
            dto.setCompanyEmail(c.getCompanyEmail());
            dto.setCompanyPhone(c.getCompanyPhone());
            dto.setCompanyName(c.getCompanyName());
            dto.setCompanyId(c.getCompanyId());
            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public CompanyUpdateRequestDTO findCompanyById(Long id) {

        Company comp = companyRepository.findById(id).orElseThrow();

        CompanyUpdateRequestDTO dto = new CompanyUpdateRequestDTO();
        dto.setCompanyPhone(comp.getCompanyPhone());
        dto.setCompanyAddress(comp.getCompanyAddress());
        dto.setCompanyName(comp.getCompanyName());
        dto.setCompanyId(comp.getCompanyId());
        dto.setCompanyEmail(comp.getCompanyEmail());

        return dto;
    }

    @Override
    public void deleteCompany(Long id) {

        Company comp = companyRepository.findById(id).orElseThrow();
        comp.setDeleted(true);

        companyRepository.save(comp);
        System.out.println("abis save bjir");
    }


}
