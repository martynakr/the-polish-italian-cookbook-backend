package com.example.thepolitcookbook.Repositories;

import com.example.thepolitcookbook.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
