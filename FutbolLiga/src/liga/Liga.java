
package liga;

public class Liga {
	private String nombre;
	private Equipo[] equipos;
	private Arbitro[] arbitros;
	private Arbitro[] liniers;
	private Arbitro[] asistentes;
	private Calendario calendario;
	private Clasificacion clasificacion;
	
	public Liga(String nombre, Equipo[] equipos, Arbitro[] arbitros, Arbitro[] liniers, Arbitro[] asistentes) {
		this.nombre=nombre;
		this.equipos=equipos;
		this.arbitros=arbitros;
		this.liniers=liniers;
		this.asistentes=asistentes;
		
		//Generamos calendario
		calendario = new Calendario(this.equipos,this.arbitros,this.liniers,this.asistentes);
		
		
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
	
	public Arbitro[] getLinier() {
		return liniers;
	}
	public void setLinier(Arbitro[] liniers) {
			this.liniers = liniers;
	}
	
	public Arbitro[] getAsistente() {
		return asistentes;
	}
	public void setAsistente(Arbitro[] asistentes) {
			this.asistentes = asistentes;
	}
}
