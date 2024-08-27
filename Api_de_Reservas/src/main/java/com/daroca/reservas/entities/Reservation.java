package com.daroca.reservas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "space_id")
    private Space space;

    @Column(name="starting_time")
    private LocalTime startingTime;

    @Column(name="ending_time")
    private LocalTime endingTime;

    @Column(name="date")
    private LocalDate date;

    @Column(name="description")
    private String description;

    @Column(name="state")
    private String state;


    public Reservation() {
    }

    public Reservation(User user, Space space, LocalTime startingTime, LocalTime endingTime, LocalDate date, String description, String state) {
        this.user = user;
        this.space = space;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.date = date;
        this.description = description;
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalTime endingTime) {
        this.endingTime = endingTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", space=" + space +
                ", startingTime=" + startingTime +
                ", endingTime=" + endingTime +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
