package com.daroca.reservas.rest;

import com.daroca.reservas.entities.*;
import com.daroca.reservas.service.ReservationsFacilitiesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/divisions")
public class DivisionsRestController {

    private ReservationsFacilitiesService reservationsFacilitiesService;

    public DivisionsRestController(ReservationsFacilitiesService reservationsFacilitiesService) {
        this.reservationsFacilitiesService = reservationsFacilitiesService;
    }


    @GetMapping("/{id}")
    public Division getDivisionById(@PathVariable int id){
        Division division=reservationsFacilitiesService.findDivisionById(id);
        if(division==null){
            throw new RuntimeException("division id not found "+ id);
        }
        return division;
    }

    @PostMapping("/save")
    public Division createDivision(@RequestBody Division division){
        division.setId(0);
        return reservationsFacilitiesService.saveDivision(division);
    }

    @PutMapping("/save")
    public Division updateDivision(@RequestBody Division division){

        return reservationsFacilitiesService.saveDivision(division);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        Division division=reservationsFacilitiesService.findDivisionById(id);
        if(division==null){
            throw new RuntimeException("Division id not found "+ id);
        }
        reservationsFacilitiesService.deleteDivision(id);
        return "Division deleted with id "+ id;
    }


    @GetMapping("/facility")
    public List<Division> getDivisionByFacilityId(@RequestBody Facility facility){
        List<Division> divisions=reservationsFacilitiesService.findListOfDivisionsByFacility(facility);
        if(divisions==null){
            throw new RuntimeException("Reservation id not found "+ facility);
        }
        return divisions;
    }
}
