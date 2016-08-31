package db;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Evento;
import jacklow.model.Robo;
import jacklow.model.Vehiculo;

public class TraerDatos {

	@Test
	public void test() {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		Robo robo = entityManager.find(Robo.class, 2l);
		
		
		robo.getEventos().stream().forEach(evento->System.out.println(evento.getDescripcion() + "\n"));
		System.out.println(robo.getVehiculo().getPatente());
	}
	
	@Test public void datosEvento(){
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		Evento evento = entityManager.find(Evento.class, 3l);
		System.out.println(evento.getRobo().getCodigoDenuncia());
	}

}
