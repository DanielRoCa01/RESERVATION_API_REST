package com.daroca.reservas.entities;

import jakarta.persistence.*;

public class UserSearch implements Search{



    private String role;

    private Facility facility;

    private Division division;

    public UserSearch() {
    }

    public UserSearch(String role, Facility facility, Division division) {

        this.role =role.isEmpty()? null:role;
        this.facility = facility;
        this.division = division;
    }

    @Override
    public Query toQuery(EntityManager entityManager) {
        StringBuilder jpql = new StringBuilder("SELECT u FROM User u WHERE u.facility= :facility");

        // Agregar condiciones según los parámetros recibidos
        if (division != null) {
            jpql.append(" AND u.division = :division");
        }

        if (role != null) {
            jpql.append(" AND u.role = :role");
        }
        TypedQuery<User> query = entityManager.createQuery(jpql.toString(), User.class);
        query.setParameter("facility", facility);

        if (division != null) {
            query.setParameter("division", division);
        }
        if (role != null ) {

            query.setParameter("role", role);

        }



        return  query;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "UserSearch{" +
                "role='" + role + '\'' +
                ", facility=" + facility +
                ", division=" + division +
                '}';
    }
}
