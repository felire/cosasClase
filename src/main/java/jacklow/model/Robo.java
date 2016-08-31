package jacklow.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.IndexColumn;
import org.uqbarproject.jpa.java8.extras.convert.LocalDateConverter;
import org.uqbarproject.jpa.java8.extras.convert.LocalDateTimeConverter;

@Entity
public class Robo {
	
	public Robo(LocalDateTime f, String d, String o, String z, String c, Vehiculo v){
		fecha = f;
		denunciante = d;
		operador = o;
		zona = z;
		codigoDenuncia = c;
		vehiculo = v;
	}
	@Id @GeneratedValue
	private long id;
	@Convert(converter = LocalDateTimeConverter.class) //Esto es un adapter de localDateTime al dato que usa mysql
	private LocalDateTime fecha;
	private String denunciante;
	private String operador;
	private String zona;
	private String codigoDenuncia;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY/*, mappedBy = "Robo"*/) // --->>> Esto buscaria los eventos que tengan una FK a este robo
	//@Cascade(value = CascadeType.ALL)
	//@OrderColumn(name = "id")  //-->> Aca le digo que los eventos los ordene segun el parametro id
	@JoinColumn(name="roboId")
	// Los SET no necesitan ser ordenados, no se repiten, los LIST si. 
	private List<Evento> eventos;
	

	//LAZY hace el select despues del robo.getVehiculo(), trae el vehiculo cuando lo necesita
	//EAGER hace el select ni bien lo trae, trae el robo+vehiculo
	//La eleccion de estos dos depende de la demanda que tengo del dato.
	//Aca busco el Vehiculo con PK de la FK de mi robo
	//@Column(name = "vehiculo_id")
	
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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public void setDenunciante(String denunciante) {
		this.denunciante = denunciante;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public void setCodigoDenuncia(String codigoDenuncia) {
		this.codigoDenuncia = codigoDenuncia;
	}
	

}
