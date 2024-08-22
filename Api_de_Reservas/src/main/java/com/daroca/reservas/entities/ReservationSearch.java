package com.daroca.reservas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationSearch implements Search{


    private User user;

    private Space space;

    private LocalTime startingTime;

    private LocalTime endingTime;

    private LocalDate date;


    private Facility facility;

    private String state;

    public ReservationSearch() {
    }

    public ReservationSearch(User user, Space space, LocalTime startingTime, LocalTime endingTime, LocalDate date, Facility facility, String state) {
        this.user = user;
        this.space = space;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.date = date;
        this.facility = facility;
        this.state = state;
    }


    @Override
    public String toString() {
        return "ReservationSearch{" +
                "user=" + user +
                ", space=" + space +
                ", startingTime=" + startingTime +
                ", endingTime=" + endingTime +
                ", date=" + date +
                ", facility=" + facility +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public Query toQuery(EntityManager entityManager) {
        StringBuilder jpql = getJpqlQueryString();
        TypedQuery<Reservation> query = entityManager.createQuery(jpql.toString(), Reservation.class);
        addParameters(query);
        return query;
    }

    private void addParameters(TypedQuery<Reservation> query) {
        query.setParameter("facility", facility);

        if (date != null) {
            query.setParameter("date", date);
        }

        if (startingTime != null) {
            query.setParameter("startingTime", startingTime);
        }

        if (endingTime != null) {
            query.setParameter("endingTime", endingTime);
        }

        if (space != null) {
            query.setParameter("space", space);
        }

        if (user != null) {
            query.setParameter("user", user);
        }
        if (state!=null) {
            query.setParameter("state", state);
        }
    }

    private StringBuilder getJpqlQueryString() {
        StringBuilder jpql = new StringBuilder("SELECT r FROM Reservation r WHERE r.space in" +
                "(SELECT e FROM Space e where e.facility=:facility)");
        if (date != null) {
            jpql.append(" AND date = :date");
        }

        if (startingTime != null) {
            jpql.append(" AND startingTime >=:startingTime ");
        }

        if (endingTime != null) {
            jpql.append(" AND endingTime <= :endingTime");
        }

        if (space != null) {
            jpql.append(" AND space = :space");
        }

        if (user != null) {
            jpql.append(" AND user = :user");
        }
        if (state!=null) {
            jpql.append(" AND state = :state");
        }
        return jpql;
    }

}
