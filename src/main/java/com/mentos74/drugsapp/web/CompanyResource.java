package com.mentos74.drugsapp.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class CompanyResource {

    public String addCompany(Model model){


        return "company/add_company";
    }


}
