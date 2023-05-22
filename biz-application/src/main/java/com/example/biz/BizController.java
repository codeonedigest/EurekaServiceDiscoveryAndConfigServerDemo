package com.example.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BizController {

    @Autowired
    BizService bizService;

    @GetMapping("/companies")
    public List<Company> getAllCompany() {
        return bizService.getCompany();
    }

    @GetMapping("/companies/{name}")
    public List<Company> getAllCompany(@PathVariable String name) {
        return bizService.getCompany();
    }

    @PostMapping("/company/add")
    public ResponseEntity<?> addCompany(@RequestBody Company company) {
        log.info("Adding Company {} with twittername {}", company.getName(), company.getTwitterUsername());
        Company company1 = bizService.addCompany(company.getName(), company.getTwitterUsername());
        if (null == company1) {
            return new ResponseEntity<>("Invalid Input!! Check the length of Company name.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(company1, HttpStatus.OK);
        }
    }
}
