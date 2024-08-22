package com.daroca.reservas.dao;

import com.daroca.reservas.entities.*;

import java.util.List;

public interface ReservationsFacilitiesDAO {

    void saveDivision(Division division);

    void saveFacility(Facility facility);

    void saveReservation(Reservation reservation);

    void saveSpace(Space space);

    void saveUser(User user);

    User findUserById(int id);

    Facility findFacilityById(int id);

    List<Space> findListOfSpacesByFacility(Facility facility);

    List<User> findListOfUsersByFacility(Facility facility);

    List<Division> findListOfDivisionsByFacility(Facility facility);

    List<Space> findListOfFreeSpacesBySearch(SpaceSearch spaceSearch);

    List<User> findListOfUsersBySearch(int id);

    List<Reservation> findListOfReservationsBySearch(int id);

    void deleteDivision(Division division);

    void deleteFacility(Facility facility);

    void deleteReservation(Reservation reservation);

    void deleteSpace(Space space);

    void deleteUser(User user);


}
