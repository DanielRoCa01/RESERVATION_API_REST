package com.daroca.reservas.entities;

import jakarta.persistence.*;

public class UserSearch implements Search{


    private String name;

    private String role;

    private Facility facility;

    private Division division;

    public UserSearch(String name, String role, Facility facility, Division division) {
        this.name = name;
        this.role = role;
        this.facility = facility;
        this.division = division;
    }

    @Override
    public TypedQuery<Object> toQuery(EntityManager entityManager) {
       return  null;
    }
}
