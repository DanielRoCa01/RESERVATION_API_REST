package com.daroca.reservas.rest;

import com.daroca.reservas.entities.*;
import com.daroca.reservas.service.ReservationsFacilitiesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UsersRestController {

    private ReservationsFacilitiesService reservationsFacilitiesService;

    public UsersRestController(ReservationsFacilitiesService reservationsFacilitiesService) {
        this.reservationsFacilitiesService = reservationsFacilitiesService;
    }



    @GetMapping("{id}")
    public User getUserById(@PathVariable int id){
        User user=reservationsFacilitiesService.findUserById(id);
        if(user==null){
            throw new RuntimeException("User id not found "+ id);
        }
        return user;
    }

    @GetMapping("/search")
    public List<User> getReservationById(@RequestBody UserSearch search){
        List<User> users=reservationsFacilitiesService.findListOfUsersBySearch(search);
        if(users==null){
            throw new RuntimeException("Reservation id not found "+ search);
        }
        return users;
    }

    @GetMapping("/facility")
    public List<User> getUsersByFacility(@RequestBody Facility facility){
        List<User> users=reservationsFacilitiesService.findListOfUsersByFacility(facility);
        if(users==null){
            throw new RuntimeException("Reservation id not found "+ facility);
        }
        return users;
    }
    @PostMapping("/save")
    public User createUser(@RequestBody User user){
        user.setId(0);
        return reservationsFacilitiesService.saveUser(user);
    }

    @PutMapping("/save")
    public User updateUser(@RequestBody User user){

        return reservationsFacilitiesService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        User user=reservationsFacilitiesService.findUserById(id);
        if(user==null){
            throw new RuntimeException("User id not found "+ id);
        }
        reservationsFacilitiesService.deleteUser(id);
        return "User deleted with id "+ id;
    }
}
