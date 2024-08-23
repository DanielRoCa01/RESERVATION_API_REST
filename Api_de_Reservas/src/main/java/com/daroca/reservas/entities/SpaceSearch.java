package com.daroca.reservas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class SpaceSearch implements Search{


    private LocalTime sinceTime;

    private LocalTime toTime;

    private LocalDate date;

    private Facility facility;

    public SpaceSearch() {
    }

    public SpaceSearch(LocalTime sinceTime, LocalTime toTime, LocalDate date, Facility facility) {
        this.sinceTime = sinceTime;
        this.toTime = toTime;
        this.date = date;
        this.facility = facility;
    }

    @Override
    public Query toQuery(EntityManager entityManager) {
        String jpql = "SELECT e FROM Space e WHERE e.facility = :facility " +
                "AND NOT (e.openningTime > :sinceTime OR e.closingTime < :sinceTime " +
                "OR e.openningTime > :toTime OR e.closingTime < :toTime) " +
                "AND e NOT IN (" +
                "    SELECT r.space FROM Reservation r " +
                "    WHERE function('DATEDIFF', r.date, :date) = 0 " +
                "    AND r.state != 'CANCELADA' " +
                "    AND ((r.startingTime >= :sinceTime AND r.startingTime < :toTime) " +
                "    OR (r.endingTime > :sinceTime AND r.endingTime <= :toTime) " +
                "     OR (r.startingTime <= :sinceTime AND r.endingTime >= :toTime)) " +
                "    GROUP BY r.space" +
                ")";

        TypedQuery<Space> query = entityManager.createQuery(jpql, Space.class);
        query.setParameter("facility", facility);
        query.setParameter("date", date);
        query.setParameter("sinceTime", sinceTime);
        query.setParameter("toTime", toTime);

        return query;
    }

    public LocalTime getSinceTime() {
        return sinceTime;
    }

    public void setSinceTime(LocalTime sinceTime) {
        this.sinceTime = sinceTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "SpaceSearch{" +
                "sinceTime=" + sinceTime +
                ", toTime=" + toTime +
                ", date=" + date +
                ", facility=" + facility +
                '}';
    }
}
