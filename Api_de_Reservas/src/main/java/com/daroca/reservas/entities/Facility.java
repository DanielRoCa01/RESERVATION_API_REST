package com.daroca.reservas.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="facility_id")
    private List<User> users;

    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name="facility_id")
    private List<Division> divisions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="facility_id")
    private List<Space> spaces;

    public Facility() {
    }

    public Facility(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void updateTables(Facility facility){
        this.spaces=facility.spaces;
        this.divisions=facility.divisions;
        this.users=facility.users;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
