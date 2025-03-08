package com.enviro.assessment.grad001.kamogeloellenkganakga.entities;

import jakarta.persistence.*;

@Entity
//table
public class WasteCategory {

    @Id
    //unique identifier of obj stored in db
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

