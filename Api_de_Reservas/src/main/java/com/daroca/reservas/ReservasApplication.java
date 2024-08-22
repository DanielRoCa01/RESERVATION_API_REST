package com.daroca.reservas;

import com.daroca.reservas.dao.ReservationsFacilitiesDAO;
import com.daroca.reservas.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class ReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservasApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (ReservationsFacilitiesDAO reservationsFacilitiesDAO){
		return runner->{

			//findUser(reservationsFacilitiesDAO);
			//findUsersByFacility(reservationsFacilitiesDAO);
			findSpacesByFacility(reservationsFacilitiesDAO);
			//findDivisionsByFacility(reservationsFacilitiesDAO);
			findFreeSpaces(reservationsFacilitiesDAO);
		};
	}

	private void findFreeSpaces(ReservationsFacilitiesDAO reservationsFacilitiesDAO) {
		int id=1;
		System.out.println("Buscando Instalcion con id :"+id);
		Facility facility=reservationsFacilitiesDAO.findFacilityById(1);
		SpaceSearch spaceSearch= new SpaceSearch(LocalTime.parse("11:30:00"),LocalTime.parse("20:00:00"), LocalDate.parse("2024-05-31"),facility);
		System.out.println("Buscando espacios libres de la busqueda :"+spaceSearch);
		System.out.println("espacios :");
		for(Space space:reservationsFacilitiesDAO.findListOfFreeSpacesBySearch(spaceSearch)){
			System.out.println(" 	"+space);
		}
	}

	private void findUsersByFacility(ReservationsFacilitiesDAO reservationsFacilitiesDAO) {
		int id=1;
		System.out.println("Buscando Instalcion con id :"+id);
		Facility facility=reservationsFacilitiesDAO.findFacilityById(1);
		System.out.println("Buscando Usuarios de la instalacion :"+facility);
		System.out.println("Usuarios :");
		for(User user:reservationsFacilitiesDAO.findListOfUsersByFacility(facility)){
			System.out.println(" 	"+user);
		}
	}
	private void findSpacesByFacility(ReservationsFacilitiesDAO reservationsFacilitiesDAO) {
		int id=1;
		System.out.println("Buscando Instalcion con id :"+id);
		Facility facility=reservationsFacilitiesDAO.findFacilityById(1);
		System.out.println("Buscando espacios de la instalacion :"+facility);
		System.out.println("espacios :");
		for(Space space:reservationsFacilitiesDAO.findListOfSpacesByFacility(facility)){
			System.out.println(" 	"+space);
		}
	}
	private void findDivisionsByFacility(ReservationsFacilitiesDAO reservationsFacilitiesDAO) {
		int id=1;
		System.out.println("Buscando Instalcion con id :"+id);
		Facility facility=reservationsFacilitiesDAO.findFacilityById(1);
		System.out.println("Buscando secciones de la instalacion :"+facility);
		System.out.println("secciones :");
		for(Division division:reservationsFacilitiesDAO.findListOfDivisionsByFacility(facility)){
			System.out.println(" 	"+division);
		}
	}

	private void findUser(ReservationsFacilitiesDAO reservationsFacilitiesDAO) {
		int id=1;
		System.out.println("Buscando Usuario :"+id);
		System.out.println("Usuario :"+reservationsFacilitiesDAO.findUserById(id));
	}

}
