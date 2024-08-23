package com.daroca.reservas.service;

import com.daroca.reservas.dao.ReservationsFacilitiesDAO;
import com.daroca.reservas.entities.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationsFacilitiesServiceImpl implements ReservationsFacilitiesService{
    private ReservationsFacilitiesDAO reservationsFacilitiesDAO;

    @Autowired
    public ReservationsFacilitiesServiceImpl(ReservationsFacilitiesDAO reservationsFacilitiesDAO) {
        this.reservationsFacilitiesDAO = reservationsFacilitiesDAO;
    }
    @Transactional
    @Override
    public void saveDivision(Division division) {
        reservationsFacilitiesDAO.saveDivision(division);
    }
    @Transactional
    @Override
    public void saveFacility(Facility facility) {
        reservationsFacilitiesDAO.saveFacility(facility);
    }
    @Transactional
    @Override
    public void saveReservation(Reservation reservation) {
        reservationsFacilitiesDAO.saveReservation(reservation);
    }
    @Transactional
    @Override
    public void saveSpace(Space space) {
        reservationsFacilitiesDAO.saveSpace(space);
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        reservationsFacilitiesDAO.saveUser(user);
    }

    @Override
    public User findUserById(int id) {
        return reservationsFacilitiesDAO.findUserById(id);
    }

    @Override
    public Division findDivisionById(int id) {
        return reservationsFacilitiesDAO.findDivisionById(id);
    }

    @Override
    public Facility findFacilityById(int id) {
        return reservationsFacilitiesDAO.findFacilityById(id);
    }

    @Override
    public Space findSpaceById(int id) {
        return reservationsFacilitiesDAO.findSpaceById(id);
    }

    @Override
    public Reservation findReservationById(int id) {
        return reservationsFacilitiesDAO.findReservationById(id);
    }

    @Override
    public List<Space> findListOfSpacesByFacility(Facility facility) {
        return reservationsFacilitiesDAO.findListOfSpacesByFacility(facility);
    }

    @Override
    public List<User> findListOfUsersByFacility(Facility facility) {
        return reservationsFacilitiesDAO.findListOfUsersByFacility(facility);
    }

    @Override
    public List<Division> findListOfDivisionsByFacility(Facility facility) {
        return reservationsFacilitiesDAO.findListOfDivisionsByFacility(facility);
    }

    @Override
    public List<Space> findListOfFreeSpacesBySearch(SpaceSearch spaceSearch) {
        return reservationsFacilitiesDAO.findListOfFreeSpacesBySearch(spaceSearch);
    }

    @Override
    public List<User> findListOfUsersBySearch(UserSearch userSearch) {
        return reservationsFacilitiesDAO.findListOfUsersBySearch(userSearch);
    }

    @Override
    public List<Reservation> findListOfReservationsBySearch(ReservationSearch reservationSearch) {
        return reservationsFacilitiesDAO.findListOfReservationsBySearch(reservationSearch);
    }
    @Transactional
    @Override
    public void deleteDivision(int id) {
        reservationsFacilitiesDAO.deleteDivision(id);
    }
    @Transactional
    @Override
    public void deleteFacility(int id) {
        reservationsFacilitiesDAO.deleteFacility(id);
    }
    @Transactional
    @Override
    public void deleteReservation(int id) {
        reservationsFacilitiesDAO.deleteReservation(id);
    }
    @Transactional
    @Override
    public void deleteSpace(int id) {
        reservationsFacilitiesDAO.deleteSpace(id);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        reservationsFacilitiesDAO.deleteUser(id);
    }
}
