package com.example.thepolitcookbook.Controllers;


import com.example.thepolitcookbook.Entities.Country;
import com.example.thepolitcookbook.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    private List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

}
