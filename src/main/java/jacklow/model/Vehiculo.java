package jacklow.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//Al poner esto tengo que marcarla en el persistence.xml dentro de etiquetas <class>jacklow.model.Vehiculo</class> Luego de provider
@Entity

//Si hago @Table(name="vehiculos") -->> Le digo que la tabla al crearse se llamara vehiculos
public class Vehiculo {
	//El id y la clave subrogada
	@Id @GeneratedValue
	private long id; //Con lo de arriba digo que esto es un id y una clave subrogada
	// @Transient esta notacion va si quiero que el dato de abajo no persista
	private String vtu;
	//Si quiero que la columna tenga otro nombre hago: @Column(name = vh_patente)
	private String patente;
	/*@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "vehiculo")
	private List<Robo> robos;*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/*public List<Robo> getRobos() {
		return robos;
	}
	public void setRobos(List<Robo> robos) {
		this.robos = robos;
	}*/
	@SuppressWarnings("unused")
	private Vehiculo(){} //Constructor necesario para usar hibernate por la convencion de java bind, necesita un constructor vacio
	public void setVtu(String vtu) {
		this.vtu = vtu;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public Vehiculo(String vtu, String patente) {
		super();
		this.vtu = vtu;
		this.patente = patente;
	}

	public String getVtu() {
		return vtu;
	}

	public String getPatente() {
		return patente;
	}

}
