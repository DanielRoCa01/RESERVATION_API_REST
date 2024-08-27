package com.daroca.reservas.rest;

import com.daroca.reservas.entities.*;
import com.daroca.reservas.service.ReservationsFacilitiesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/spaces")
public class SpacesRestController {

    private ReservationsFacilitiesService reservationsFacilitiesService;

    public SpacesRestController(ReservationsFacilitiesService reservationsFacilitiesService) {
        this.reservationsFacilitiesService = reservationsFacilitiesService;
    }



    @GetMapping("/{id}")
    public Space getSpaceById(@PathVariable int id){
        Space space=reservationsFacilitiesService.findSpaceById(id);
        if(space==null){
            throw new RuntimeException("Space id not found "+ id);
        }
        return space;
    }

    @GetMapping("/search")
    public List<Space> getReservationById(@RequestBody SpaceSearch search){
        List<Space> spaces=reservationsFacilitiesService.findListOfFreeSpacesBySearch(search);
        if(spaces==null){
            throw new RuntimeException("Reservation id not found "+ search);
        }
        return spaces;
    }


    @GetMapping("/facility")
    public List<Space> getSpacesByFacility(@RequestBody Facility facility){
        List<Space> spaces=reservationsFacilitiesService.findListOfSpacesByFacility(facility);
        if(spaces==null){
            throw new RuntimeException("Reservation id not found "+ facility);
        }
        return spaces;
    }
    @PostMapping("/save")
    public Space createSpace(@RequestBody Space space){
        space.setId(0);
        return reservationsFacilitiesService.saveSpace(space);
    }

    @PutMapping("/save")
    public Space updateSpace(@RequestBody Space space){

        return reservationsFacilitiesService.saveSpace(space);
    }

    @DeleteMapping("/{id}")
    public String deleteSpace(@PathVariable int id){
        Space space=reservationsFacilitiesService.findSpaceById(id);
        if(space==null){
            throw new RuntimeException("Space id not found "+ id);
        }
        reservationsFacilitiesService.deleteSpace(id);
        return "Space deleted with id "+ id;
    }
}
