package jacklow.model.eventos;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public abstract class Evento {
	
	private LocalDateTime fecha;
	
	/*
	 * Muchos muchos métodos que van a reutilizar las subclases
	 * 
	 * Inserte aquí
	 * 
	 * |
	 * |
	 * v
	 * 
	 * */

}
