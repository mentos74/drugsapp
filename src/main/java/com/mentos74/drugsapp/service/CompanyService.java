package com.mentos74.drugsapp.service;

import com.mentos74.drugsapp.dto.CompanyCreateRequestDTO;
import com.mentos74.drugsapp.dto.CompanyResponseRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    public void createNewCompany(CompanyCreateRequestDTO dto);

    public void updateCompany(CompanyUpdateRequestDTO dto, Long id);

    public List<CompanyResponseRequestDTO> listCompany();

    public CompanyUpdateRequestDTO findCompanyById(Long id);

    public void deleteCompany(Long id);



}
