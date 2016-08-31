package jacklow.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.uqbarproject.jpa.java8.extras.convert.LocalDateTimeConverter;

@Entity
public class Evento { //Le saco el abstract porque hincha los huevos
	
	public Evento(LocalDateTime fecha, String desc, Robo robo){
		this.fecha = fecha;
		this.descripcion = desc;
		this.robo = robo;
	}
	@Id @GeneratedValue
	private long id;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime fecha;
	
	private String descripcion;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "roboId")
	private Robo robo;
	//@Column(name = "robo_id")
	/*@ManyToOne(fetch = FetchType.LAZY)
	private Robo robo;*/
	
	@SuppressWarnings("unused")
	private Evento(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Robo getRobo() {
		return robo;
	}

	public void setRobo(Robo robo) {
		this.robo = robo;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
