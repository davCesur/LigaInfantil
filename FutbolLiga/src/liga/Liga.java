
package liga;

public class Liga {
	private String nombre;
	private Equipo[] equipos;
	private Arbitro[] arbitros;
	private Calendario calendario;
	private Clasificacion clasificacion;
	
	public Liga(String nombre, Equipo[] equipos, Arbitro[] arbitros) {
		this.nombre=nombre;
		this.equipos=equipos;
		this.arbitros=arbitros;
		
		//Generamos calendario
		calendario = new Calendario(this.equipos,this.arbitros);
		
		
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre+" infantil.";
	}
	public Equipo[] getEquipos() {
		return equipos;
	}
	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}
	public Arbitro[] getArbitros() {
		return arbitros;
	}
	public void setArbitros(Arbitro[] arbitros) {
		this.arbitros = arbitros;
	}
	public Calendario getCalendario() {
		return calendario;
	}
	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	public Clasificacion getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}
}
