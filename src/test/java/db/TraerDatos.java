package db;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Robo;

public class TraerDatos {

	@Test
	public void test() {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		Robo robo = entityManager.find(Robo.class, 1l);
		
		//robo.getEventos().stream().forEach(evento->System.out.println(evento.getDescripcion() + "\n"));
	}

}
