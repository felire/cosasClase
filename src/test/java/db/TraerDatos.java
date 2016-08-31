package db;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Robo;
import jacklow.model.Vehiculo;

public class TraerDatos {

	@Test
	public void test() {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		Vehiculo vehiculo = entityManager.find(Vehiculo.class, 1l);
		Robo robo = entityManager.find(Robo.class, 1l);
		
		
		robo.getEventos().stream().forEach(evento->System.out.println(evento.getDescripcion() + "\n"));
	}

}
