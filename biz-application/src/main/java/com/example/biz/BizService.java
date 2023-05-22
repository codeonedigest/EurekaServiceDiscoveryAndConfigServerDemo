package com.example.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BizService {

    @Value("${biz.application.name.limit}")
    private int companyNameLengthLimit;

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getCompany() {
        log.info("Getting all companies from repository ....");
        return companyRepository.findAll();
    }

    public List<Company> getCompany(String name) {
        log.info("Getting company by name {} from repository ....", name);
        return companyRepository.findByName(name);
    }

    public Company addCompany(String name, String twitterUsername) {
        log.info("Adding Company {} with TwitterName {}", name, twitterUsername);
        log.info("Checking the length of company name ..... ");

        if (companyNameLengthLimit < name.length()) {
            log.error("Invalid length {}of company name...", name.length());
            return null;
        }
        Company company = new Company();
        company.setName(name);
        company.setTwitterUsername(twitterUsername);
        return addCompany(company);
    }

    private Company addCompany(Company company) {
        return companyRepository.save(company);
    }
}
