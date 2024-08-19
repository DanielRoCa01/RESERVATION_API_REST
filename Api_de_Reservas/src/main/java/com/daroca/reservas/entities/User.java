package com.daroca.reservas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idInstalacion")
    private Facility facility;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSeccion")
    private Division division;

    public User() {
    }

    public User(String name, String role, Facility facility, Division division) {
        this.name = name;
        this.role = role;
        this.facility = facility;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", facility=" + facility +
                ", division=" + division +
                '}';
    }
}
