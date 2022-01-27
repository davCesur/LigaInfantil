/**
 * Monta un partido.
 * Necesita:
 * 	2 equipos
 * 	Fecha de partido
 * Genera:
 *  3 árbitros
 *  resultado
 */

public class Partido {

	// 0 => equipo local | 1 => equipo visitante
	private Equipo[] equipos= new Equipo[2];
	
	// 0 => principal | 1 => linier | 2 => asistente
	private Arbitro[] arbitros = new Arbitro[3];

	private Calendario calendario;

	// 0 => equipo local | 1 => equipo visitante
	private int resultado[] = {0,0};

		
	
	public String getNombre() {
		return equipos[0].getNombre() + " VS " + equipos[1].getNombre();
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
		
		// Principal
		this.arbitros[0] = new Arbitro();
		// Linier
		this.arbitros[1] = new Arbitro();
		// Asistente
		this.arbitros[2] = new Arbitro();
		
		
		
		
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public int[] getResultado() {
		return resultado;
	}

	public void setResultado(int[] resultado) {
		this.resultado = resultado;
	}
	
	public String toString() {
		return "Partido: " + this.getNombre() +" /n"
				+ "Arbitro: " + arbitros +" /n "
				+ "Resultado:" + resultado +" /n"
				+ "Fecha: " + calendario;
	}
	
	
	

	
}
