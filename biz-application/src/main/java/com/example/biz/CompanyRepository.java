package com.example.biz;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface CompanyRepository extends CrudRepository<Company, Long> {

    List<Company> findAll();

    List<Company> findByName(String name);

    Company save(Company company);
}
