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
			//findSpacesByFacility(reservationsFacilitiesDAO);
			//findDivisionsByFacility(reservationsFacilitiesDAO);
			//findFreeSpaces(reservationsFacilitiesDAO);
			//findUsersBySearch(reservationsFacilitiesDAO);
			//findReservationsBySearch(reservationsFacilitiesDAO);
			createEntities(reservationsFacilitiesDAO);
		};
	}

	private void createEntities(ReservationsFacilitiesDAO reservationsFacilitiesDAO) {
		Facility facility=new Facility("Casa","Pequeñita");

		Division division=new Division("Adultos","Los no niños",facility);
		Division division2=new Division("Niños","Los si niños",facility);

		User user =new User("Daniela","ADMINISTRADOR",facility,division);
		User user2 =new User("Julia","USUARIO",facility,division2);

		Space space=new Space("Cocina","XL",LocalTime.parse("10:00:00"),LocalTime.parse("12:00:00"),"Muy equipada",facility);

		Reservation reservation=new Reservation(user,space,LocalTime.parse("10:00:00"),LocalTime.parse("10:00:00"),LocalDate.parse("2024-05-31"),"Reservola cocina","RESERVADA");
		reservationsFacilitiesDAO.saveReservation(reservation);
	}

	private void findReservationsBySearch(ReservationsFacilitiesDAO reservationsFacilitiesDAO) {
		int id=1;
		System.out.println("Buscando Instalcion con id :"+id);
		Facility facility=reservationsFacilitiesDAO.findFacilityById(1);
		System.out.println("Buscando Usuario con id :"+id);
		User user=reservationsFacilitiesDAO.findUserById(1);
		System.out.println("Buscando Espacio con id :"+id);
		Space space=reservationsFacilitiesDAO.findSpaceById(1);
		LocalTime time1=LocalTime.parse("10:00:00");
		LocalTime time2=LocalTime.parse("12:00:00");
		LocalDate date=LocalDate.parse("2024-05-31");
		String state="CANCELADA";
		ReservationSearch reservationSearch=new ReservationSearch(null,null,time1,null,date,facility,state);
		System.out.println("Buscando Reservas por la busqueda:"+reservationSearch);
		System.out.println("Reservas :");
		for(Reservation reservation:reservationsFacilitiesDAO.findListOfReservationsBySearch(reservationSearch)){
			System.out.println(" 	"+reservation);
		}
	}

	private void findUsersBySearch(ReservationsFacilitiesDAO reservationsFacilitiesDAO) {
		int id=1;
		System.out.println("Buscando Instalcion con id :"+id);
		Facility facility=reservationsFacilitiesDAO.findFacilityById(1);
		System.out.println("Buscando Seccion con id :"+id);
		Division division=reservationsFacilitiesDAO.findDivisionById(1);
		UserSearch userSearch=new UserSearch("",facility,division);
		System.out.println("Buscando Usuarios por la busqueda:"+userSearch);
		System.out.println("Usuarios :");
		for(User user:reservationsFacilitiesDAO.findListOfUsersBySearch(userSearch)){
			System.out.println(" 	"+user);
		}
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
