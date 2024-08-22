package com.daroca.reservas.dao;

import com.daroca.reservas.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationsFacilitiesDAOImpl implements ReservationsFacilitiesDAO{

    private EntityManager entityManager;

    @Autowired
    public ReservationsFacilitiesDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void saveDivision(Division division) {
        entityManager.merge(division);
    }

    @Override
    public void saveFacility(Facility facility) {
        entityManager.merge(facility);
    }

    @Override
    public void saveReservation(Reservation reservation) {
        entityManager.merge(reservation);
    }

    @Override
    public void saveSpace(Space space) {
        entityManager.merge(space);
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public Facility findFacilityById(int id) {
        return entityManager.find(Facility.class,id);
    }

    @Override
    public List<Space> findListOfSpacesByFacility(Facility facility) {
        TypedQuery<Space> query =entityManager.createQuery("FROM Space s where s.facility= :facility",Space.class);
        query.setParameter("facility",facility);
         return query.getResultList();
    }

    @Override
    public List<User> findListOfUsersByFacility(Facility facility) {
        TypedQuery<User> query =entityManager.createQuery("FROM User u where u.facility= :facility",User.class);
        query.setParameter("facility",facility);
        return query.getResultList();
    }

    @Override
    public List<Division> findListOfDivisionsByFacility(Facility facility) {
        TypedQuery<Division> query =entityManager.createQuery("FROM Division d where d.facility= :facility",Division.class);
        query.setParameter("facility",facility);
        return query.getResultList();
    }

    @Override
    public List<Space> findListOfFreeSpacesBySearch(SpaceSearch search) {
        return (List<Space>) search.toQuery(entityManager).getResultList();
    }

    @Override
    public List<User> findListOfUsersBySearch(int id) {
        return null;
    }

    @Override
    public List<Reservation> findListOfReservationsBySearch(int id) {
        return null;
    }

    @Override
    public void deleteDivision(Division division) {

    }

    @Override
    public void deleteFacility(Facility facility) {

    }

    @Override
    public void deleteReservation(Reservation reservation) {

    }

    @Override
    public void deleteSpace(Space space) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
