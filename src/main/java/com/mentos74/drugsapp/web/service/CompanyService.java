package com.mentos74.drugsapp.web.service;

import com.mentos74.drugsapp.web.dto.CompanyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    public void createNewCompany(CompanyDTO dto);

    public void updateCompany(CompanyDTO dto);

    public List<CompanyDTO> listCompany();

    public CompanyDTO findCompanyById(Long id);

    public void deleteCompany(Long id);



}
