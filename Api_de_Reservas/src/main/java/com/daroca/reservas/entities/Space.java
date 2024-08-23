package com.daroca.reservas.entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="space")
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="size")
    private String size;

    @Column(name="opening_time")
    private LocalTime openningTime;

    @Column(name="closing_time")
    private LocalTime closingTime;

    @Column(name="description")
    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="space_id")
    private List<Reservation> reservations;
    public Space() {
    }

    public Space(String name, String size, LocalTime openTime, LocalTime closeTime, String description, Facility facility) {
        this.name = name;
        this.size = size;
        this.openningTime = openTime;
        this.closingTime = closeTime;
        this.description = description;
        this.facility = facility;
    }

    public void updateTables(Space space){
        this.reservations=space.reservations;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public LocalTime getOpenningTime() {
        return openningTime;
    }

    public void setOpenningTime(LocalTime openningTime) {
        this.openningTime = openningTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Space{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", openTime=" + openningTime +
                ", closeTime=" + closingTime +
                ", description='" + description + '\'' +
                ", facility=" + facility +
                '}';
    }
}
