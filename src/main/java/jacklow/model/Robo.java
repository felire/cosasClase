package jacklow.model;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.*;

import org.uqbarproject.jpa.java8.extras.convert.LocalDateConverter;
import org.uqbarproject.jpa.java8.extras.convert.LocalDateTimeConverter;

@Entity
public class Robo {
	
	@Id @GeneratedValue
	private long id;
	@Convert(converter = LocalDateTimeConverter.class) //Esto es un adapter de localDateTime al dato que usa mysql
	private LocalDateTime fecha;
	private String denunciante;
	private String operador;
	private String zona;
	private String codigoDenuncia;
	
	//@OneToMany  --->>> Esto buscaria los eventos que tengan una FK a este robo
	//@OrderColumn(name = "orden")  -->> Aca le digo que los eventos los ordene segun el parametro orden
	// Los SET no necesitan ser ordenados, no se repiten, los LIST si. 
//	private List<Evento> eventos;
	//LAZY hace el select despues del robo.getVehiculo(), trae el vehiculo cuando lo necesita
	//EAGER hace el select ni bien lo trae, trae el robo+vehiculo
	//La eleccion de estos dos depende de la demanda que tengo del dato.
	//Aca busco el Vehiculo con PK de la FK de mi robo
	@ManyToOne(fetch = FetchType.LAZY)  //Le digo que esto es una relacion muchos a 1. Va del lado de muchos. 
	private Vehiculo vehiculo; //Sera una FK en el modelo relacional.
	@SuppressWarnings("unused")
	private Robo(){}
	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getDenunciante() {
		return denunciante;
	}

	public String getOperador() {
		return operador;
	}

	public String getZona() {
		return zona;
	}

	public String getCodigoDenuncia() {
		return codigoDenuncia;
	}

}
