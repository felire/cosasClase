package db;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import jacklow.model.Vehiculo;

 
public class Practica {

	@Test
	public void solicitarInformacion() {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager(); //Esto usa hibernate para mapear
		Vehiculo vehiculo = entityManager.find(Vehiculo.class, 1l);//Me tra el de el id 1
		System.out.println(vehiculo.getPatente());
		System.out.println(vehiculo.getVtu());
		entityManager.clear(); //Borra la cache, entonces las instancias seran distintas
		Vehiculo vehiculo2 = entityManager.find(Vehiculo.class, 1l);
		assertTrue(vehiculo != vehiculo2);   //Hibernate deberia devolver la misma instancia de los objetos
		
		
		//Consulta mas compleja
		//   :patente es un parametro
		/*Vehiculo vehiculo3 = (Vehiculo) entityManager.createQuery("from Vehiculo where patente = :patente")//Recibe un JQL Java Query Language, no consulta con tablas, consulta con objetos
		.setParameter("patente", "asd")
		.getSingleResult();*/
		
		//Para traer una lista hago: -> Traeria toda la lista de vehiculos
//		(List<Vehiculo>) entityManager.createQuery("from Vehiculo)//Recibe un JQL Java Query Language, no consulta con tablas, consulta con objetos
//		
//		.getResultList();
		//System.out.println(vehiculo3 == vehiculo2);
	}
	
	@Test
	public void updatearInfo(){
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		Vehiculo vehiculo3 = entityManager.find(Vehiculo.class, 1l);
		
		EntityTransaction tx = entityManager.getTransaction(); //Hay que solicitar transaccion ee
		tx.begin(); //Hay que iniciar la transaction
		
		vehiculo3.setPatente("patensita");
		tx.commit();  //Mandamos a actualizar los datos	
		//tx.begin();
		Vehiculo vehiculo4 = new Vehiculo("eee", "patenteasd");
		//tx.commit();*/
		tx.begin();
		entityManager.persist(vehiculo4);
		tx.commit();
		
		//Todos las peticiones que tengan un efecto en la base de datos van dentro de una transaccion, begin y commit
	}

}
