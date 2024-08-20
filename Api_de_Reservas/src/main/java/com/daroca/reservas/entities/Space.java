package com.daroca.reservas.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name="espacios")
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String name;

    @Column(name="tamaño")
    private String size;

    @Column(name="horaApertura")
    private LocalTime openTime;

    @Column(name="horaCierre")
    private LocalTime closeTime;

    @Column(name="descripcion")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idInstalacion")
    private Facility facility;

    public Space() {
    }

    public Space(String name, String size, LocalTime openTime, LocalTime closeTime, String description, Facility facility) {
        this.name = name;
        this.size = size;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.description = description;
        this.facility = facility;
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

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
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
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", description='" + description + '\'' +
                ", facility=" + facility +
                '}';
    }
}
