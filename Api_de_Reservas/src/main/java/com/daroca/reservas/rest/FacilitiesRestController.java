package com.daroca.reservas.rest;

import com.daroca.reservas.entities.*;
import com.daroca.reservas.service.ReservationsFacilitiesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class FacilitiesRestController {

    private ReservationsFacilitiesService reservationsFacilitiesService;

    public FacilitiesRestController(ReservationsFacilitiesService reservationsFacilitiesService) {
        this.reservationsFacilitiesService = reservationsFacilitiesService;
    }

    @GetMapping("/facility/{id}")
    public Facility getFacilityById(@PathVariable int id){
        Facility facility=reservationsFacilitiesService.findFacilityById(id);
        if(facility==null){
            throw new RuntimeException("Facility id not found "+ id);
        }
        return facility;
    }
    @GetMapping("/division/{id}")
    public Division getDivisionById(@PathVariable int id){
        Division division=reservationsFacilitiesService.findDivisionById(id);
        if(division==null){
            throw new RuntimeException("division id not found "+ id);
        }
        return division;
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        User user=reservationsFacilitiesService.findUserById(id);
        if(user==null){
            throw new RuntimeException("User id not found "+ id);
        }
        return user;
    }
    @GetMapping("/space/{id}")
    public Space getSpaceById(@PathVariable int id){
        Space space=reservationsFacilitiesService.findSpaceById(id);
        if(space==null){
            throw new RuntimeException("Space id not found "+ id);
        }
        return space;
    }
    @GetMapping("/reservation/{id}")
    public Reservation getReservationById(@PathVariable int id){
        Reservation reservation=reservationsFacilitiesService.findReservationById(id);
        if(reservation==null){
            throw new RuntimeException("Reservation id not found "+ id);
        }
        return reservation;
    }
    @GetMapping("/search/spaces")
    public List<Space> getReservationById(@RequestBody SpaceSearch search){
        List<Space> spaces=reservationsFacilitiesService.findListOfFreeSpacesBySearch(search);
        if(spaces==null){
            throw new RuntimeException("Reservation id not found "+ search);
        }
        return spaces;
    }
    @GetMapping("/search/users")
    public List<User> getReservationById(@RequestBody UserSearch search){
        List<User> users=reservationsFacilitiesService.findListOfUsersBySearch(search);
        if(users==null){
            throw new RuntimeException("Reservation id not found "+ search);
        }
        return users;
    }
    @GetMapping("/search/reservations")
    public List<Reservation> getReservationById(@RequestBody ReservationSearch search){
        List<Reservation> reservations=reservationsFacilitiesService.findListOfReservationsBySearch(search);
        if(reservations==null){
            throw new RuntimeException("Reservation id not found "+ search);
        }
        return reservations;
    }
    @GetMapping("/facility/spaces")
    public List<Space> getSpacesByFacility(@RequestBody Facility facility){
        List<Space> spaces=reservationsFacilitiesService.findListOfSpacesByFacility(facility);
        if(spaces==null){
            throw new RuntimeException("Reservation id not found "+ facility);
        }
        return spaces;
    }
    @GetMapping("/facility/users")
    public List<User> getUsersByFacility(@RequestBody Facility facility){
        List<User> users=reservationsFacilitiesService.findListOfUsersByFacility(facility);
        if(users==null){
            throw new RuntimeException("Reservation id not found "+ facility);
        }
        return users;
    }
    @GetMapping("/facility/divisions")
    public List<Division> getDivisionByFacilityId(@RequestBody Facility facility){
        List<Division> divisions=reservationsFacilitiesService.findListOfDivisionsByFacility(facility);
        if(divisions==null){
            throw new RuntimeException("Reservation id not found "+ facility);
        }
        return divisions;
    }
}
