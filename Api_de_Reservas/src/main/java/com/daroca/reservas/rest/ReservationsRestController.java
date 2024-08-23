package com.daroca.reservas.rest;

import com.daroca.reservas.entities.*;
import com.daroca.reservas.service.ReservationsFacilitiesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/reservations")
public class ReservationsRestController {

    private ReservationsFacilitiesService reservationsFacilitiesService;

    public ReservationsRestController(ReservationsFacilitiesService reservationsFacilitiesService) {
        this.reservationsFacilitiesService = reservationsFacilitiesService;
    }


    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable int id){
        Reservation reservation=reservationsFacilitiesService.findReservationById(id);
        if(reservation==null){
            throw new RuntimeException("Reservation id not found "+ id);
        }
        return reservation;
    }

    @GetMapping("/search/reservations")
    public List<Reservation> getReservationById(@RequestBody ReservationSearch search){
        List<Reservation> reservations=reservationsFacilitiesService.findListOfReservationsBySearch(search);
        if(reservations==null){
            throw new RuntimeException("Reservation id not found "+ search);
        }
        return reservations;
    }
    @PostMapping("/save")
    public Reservation createReservation(@RequestBody Reservation reservation){
        reservation.setId(0);
        return reservationsFacilitiesService.saveReservation(reservation);
    }

    @PutMapping("/save")
    public Reservation updateReservation(@RequestBody Reservation reservation){

        return reservationsFacilitiesService.saveReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public String deleteReservation(@PathVariable int id){
        Reservation reservation=reservationsFacilitiesService.findReservationById(id);
        if(reservation==null){
            throw new RuntimeException("Reservation id not found "+ id);
        }
        reservationsFacilitiesService.deleteSpace(id);
        return "Reservation deleted with id "+ id;
    }
}
