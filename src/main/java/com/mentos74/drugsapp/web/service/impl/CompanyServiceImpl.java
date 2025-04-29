package com.mentos74.drugsapp.web.service.impl;

import com.mentos74.drugsapp.web.dto.CompanyDTO;
import com.mentos74.drugsapp.web.entity.Company;
import com.mentos74.drugsapp.web.repository.CompanyRepository;
import com.mentos74.drugsapp.web.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void createNewCompany(CompanyDTO dto) {
        try {
            Company company = new Company();
            company.setCompanyName(dto.getCompanyName());
            company.setCompanyEmail(dto.getCompanyEmail());
            company.setCompanyAddress(dto.getCompanyAddress());
            company.setCompanyPhone(dto.getCompanyPhone());
            company.setCompanyCountry(dto.getCompanyCountry());
            company.setDeleted(false);
            company.prePersist();

            companyRepository.save(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCompany(CompanyDTO dto) {
        try {
            Company company = companyRepository.findById(dto.getCompanyId()).orElseThrow();
            company.setCompanyName(dto.getCompanyName());
            company.setCompanyEmail(dto.getCompanyEmail());
            company.setCompanyAddress(dto.getCompanyAddress());
            company.setCompanyPhone(dto.getCompanyPhone());
            company.setCompanyCountry(dto.getCompanyCountry());
            company.preUpdate();

            companyRepository.save(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CompanyDTO> listCompany() {
        return companyRepository.findByDeletedFalseOrderByUpdatedAtDesc().stream().map((c) -> {
            CompanyDTO dto = new CompanyDTO();
            dto.setCompanyAddress(c.getCompanyAddress());
            dto.setCompanyEmail(c.getCompanyEmail());
            dto.setCompanyPhone(c.getCompanyPhone());
            dto.setCompanyName(c.getCompanyName());
            dto.setCompanyId(c.getCompanyId());
            dto.setCompanyCountry(c.getCompanyCountry());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public CompanyDTO findCompanyById(Long id) {
        CompanyDTO dto = new CompanyDTO();
        try {
            Company comp = companyRepository.findById(id).orElseThrow();
            dto.setCompanyPhone(comp.getCompanyPhone());
            dto.setCompanyAddress(comp.getCompanyAddress());
            dto.setCompanyName(comp.getCompanyName());
            dto.setCompanyId(comp.getCompanyId());
            dto.setCompanyEmail(comp.getCompanyEmail());
            dto.setCompanyCountry(comp.getCompanyCountry());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    @Override
    public void deleteCompany(Long id) {
        try {
            Company comp = companyRepository.findById(id).orElseThrow();
            comp.setDeleted(true);

            companyRepository.save(comp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
