package com.daroca.reservas.service;

import com.daroca.reservas.entities.*;

import java.util.List;

public interface ReservationsFacilitiesService {
    void saveDivision(Division division);

    void saveFacility(Facility facility);

    void saveReservation(Reservation reservation);

    void saveSpace(Space space);

    void saveUser(User user);

    User findUserById(int id);

    Division findDivisionById(int id);

    Facility findFacilityById(int id);

    Space findSpaceById(int id);

    Reservation findReservationById(int id);

    List<Space> findListOfSpacesByFacility(Facility facility);

    List<User> findListOfUsersByFacility(Facility facility);

    List<Division> findListOfDivisionsByFacility(Facility facility);

    List<Space> findListOfFreeSpacesBySearch(SpaceSearch spaceSearch);

    List<User> findListOfUsersBySearch(UserSearch userSearch);

    List<Reservation> findListOfReservationsBySearch(ReservationSearch reservationSearch);

    void deleteDivision(int id);

    void deleteFacility(int id);

    void deleteReservation(int id);

    void deleteSpace(int id);

    void deleteUser(int id);
}
