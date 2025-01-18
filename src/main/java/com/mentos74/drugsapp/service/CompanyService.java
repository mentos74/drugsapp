package com.mentos74.drugsapp.service;

import com.mentos74.drugsapp.dto.CompanyCreateRequestDTO;
import com.mentos74.drugsapp.dto.CompanyUpdateRequestDTO;

public interface CompanyService {

    public void createNewCompany(CompanyCreateRequestDTO dto);
    public void updateCompany(CompanyUpdateRequestDTO dto);


}
