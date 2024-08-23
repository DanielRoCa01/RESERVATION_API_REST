package com.daroca.reservas.dao;

import com.daroca.reservas.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ReservationsFacilitiesDAOImpl implements ReservationsFacilitiesDAO{

    private EntityManager entityManager;

    @Autowired
    public ReservationsFacilitiesDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void saveDivision(Division division) {
        entityManager.merge(division);
    }

    @Override
    @Transactional
    public void saveFacility(Facility facility) {
        entityManager.merge(facility);
    }

    @Override
    @Transactional
    public void saveReservation(Reservation reservation) {
        entityManager.merge(reservation);
    }

    @Override
    @Transactional
    public void saveSpace(Space space) {
        entityManager.merge(space);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public Division findDivisionById(int id) {
        return entityManager.find(Division.class,id);
    }

    @Override
    public Facility findFacilityById(int id) {
        return entityManager.find(Facility.class,id);
    }

    @Override
    public Space findSpaceById(int id) {
        return entityManager.find(Space.class,id);
    }

    @Override
    public Reservation findReservationById(int id) {
        return entityManager.find(Reservation.class,id);
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
    public List<User> findListOfUsersBySearch(UserSearch search) {
        return (List<User>) search.toQuery(entityManager).getResultList();
    }

    @Override
    public List<Reservation> findListOfReservationsBySearch(ReservationSearch search) {
        return (List<Reservation>) search.toQuery(entityManager).getResultList();
    }

    @Transactional
    @Override
    public void deleteDivision(int id) {
        entityManager.remove(findDivisionById(id));
    }

    @Transactional
    @Override
    public void deleteFacility(int id) {
        entityManager.remove(findFacilityById(id));
    }

    @Transactional
    @Override
    public void deleteReservation(int id) {
        entityManager.remove(findReservationById(id));
    }

    @Transactional
    @Override
    public void deleteSpace(int id) {
        entityManager.remove(findSpaceById(id));
    }

    @Transactional
    @Override
    public void deleteUser(int id) {


        entityManager.remove(findUserById(id));
    }
}
