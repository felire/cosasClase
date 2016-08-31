package db;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Evento;
import jacklow.model.Robo;
import jacklow.model.Vehiculo;

public class RelacionBidireccional {

	@Test
	public void test() {
		LocalDateTime fechaGenerica = LocalDateTime.of(1996, Month.MAY, 14, 12, 06);
		//(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour, int secondOfMinute)
		Vehiculo vehiculo1 = new Vehiculo("que carajo es vtu", "abc111");
		//Vehiculo vehiculo2 = new Vehiculo("que carajo es vtu", "abc222");
		Robo robo1 = new Robo(fechaGenerica,"asd", "asddas", "1-11-14", "que porqueria", vehiculo1);
		
		Evento evento = new Evento(fechaGenerica, "Evento 1", robo1);
		Evento evento2 = new Evento(fechaGenerica, "Evento 2", robo1);
		List<Evento> eventos = new ArrayList<>();
		eventos.add(evento);
		eventos.add(evento2);
		robo1.setEventos(eventos);
		
		//Iniciamos transaccion
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(vehiculo1);
		entityManager.persist(robo1);
		tx.commit();
	}

}
