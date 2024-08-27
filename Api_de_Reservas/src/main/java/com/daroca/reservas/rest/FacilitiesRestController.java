package com.daroca.reservas.rest;

import com.daroca.reservas.entities.*;
import com.daroca.reservas.service.ReservationsFacilitiesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/facility")
public class FacilitiesRestController {

    private ReservationsFacilitiesService reservationsFacilitiesService;

    public FacilitiesRestController(ReservationsFacilitiesService reservationsFacilitiesService) {
        this.reservationsFacilitiesService = reservationsFacilitiesService;
    }

    @GetMapping("/{id}")
    public Facility getFacilityById(@PathVariable int id){
        Facility facility=reservationsFacilitiesService.findFacilityById(id);
        if(facility==null){
            throw new RuntimeException("Facility id not found "+ id);
        }
        return facility;
    }
    @PostMapping("/save")
    public Facility createFacility(@RequestBody Facility facility){
        facility.setId(0);
        return reservationsFacilitiesService.saveFacility(facility);
    }

    @PutMapping("/save")
    public Facility updateFacility(@RequestBody Facility facility){

        return reservationsFacilitiesService.saveFacility(facility);
    }

    @DeleteMapping("/{id}")
    public String deleteFacility(@PathVariable int id){
        Facility facility=reservationsFacilitiesService.findFacilityById(id);
        if(facility==null){
            throw new RuntimeException("Facility id not found "+ id);
        }
        reservationsFacilitiesService.deleteFacility(id);
        return "Facility deleted with id "+ id;
    }

}
