package com.example.thepolitcookbook.Entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    @NotNull
    @Column(name = "country_name")
    private String country_name;

    public Country(){};

    public Country(String country_name) {
        this.country_name = country_name;
    }
}
