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

    public Division saveDivision(Division division) {
        if(division.getId()!=0) {
            Division savedDivision = findDivisionById(division.getId());
            division.updateTables(savedDivision);

        }
        return entityManager.merge(division);
    }

    @Override
    public Facility saveFacility(Facility facility) {
        if(facility.getId()!=0) {
            Facility savedFacility = findFacilityById(facility.getId());
            facility.updateTables(savedFacility);

        }
        return entityManager.merge(facility);
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {

        return entityManager.merge(reservation);
    }

    @Override
    public Space saveSpace(Space space) {

        if(space.getId()!=0) {
            Space savedSpace = findSpaceById(space.getId());
            space.updateTables(savedSpace);

        }return entityManager.merge(space);
    }

    @Override

    public User saveUser(User user) {

        if(user.getId()!=0) {
            User savedUser = findUserById(user.getId());
            user.updateTables(savedUser);

        }return entityManager.merge(user);
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

    @Override
    public void deleteDivision(int id) {
        entityManager.remove(findDivisionById(id));
    }

    @Override
    public void deleteFacility(int id) {
        entityManager.remove(findFacilityById(id));
    }

    @Override
    public void deleteReservation(int id) {
        entityManager.remove(findReservationById(id));
    }

    @Override
    public void deleteSpace(int id) {
        entityManager.remove(findSpaceById(id));
    }

    @Override
    public void deleteUser(int id) {


        entityManager.remove(findUserById(id));
    }
}
