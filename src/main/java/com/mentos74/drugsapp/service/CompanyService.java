package com.mentos74.drugsapp.service;

import com.mentos74.drugsapp.dto.CompanyCreateRequestDTO;
import com.mentos74.drugsapp.dto.CompanyResponseRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    public void createNewCompany(CompanyCreateRequestDTO dto);

    public void updateCompany(CompanyUpdateRequestDTO dto);

    public List<CompanyResponseRequestDTO> listCompany();


}
