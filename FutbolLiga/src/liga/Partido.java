/**
 * ######### PENDIENTE DE JORNADA
 */

/**
 * Monta un partido.
 * Necesita:
 * 	2 equipos
 * 	Fecha de partido
 * Genera:
 *  3 árbitros
 *  resultado
 *  
 *  @author miguel
 *  
 */

package liga;

public class Partido {
	
	
	
	/**
	 * Constructor
	 */
	public Partido() {
		setResultado();
	}

	// 0 => equipo local | 1 => equipo visitante
	private Equipo[] equipos= new Equipo[2];
	
	// 0 => principal | 1 => linier | 2 => asistente
	private Arbitro[] arbitros = new Arbitro[3];

	/** pendiente de hacer Jornadas **/
	//private Jornadas jornada;

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
	
	public Equipo getLocal() {
		return this.equipos[0];
	}
	public void setLocal(Equipo equipo) {
		this.equipos[0] = equipo;
	}
	
	public Equipo getVisitante() {
		return this.equipos[1];
	}
	public void setVisitante(Equipo equipo) {
		this.equipos[1] = equipo;
	}


	public int[] getResultado() {
		return resultado;
	}

	public void setResultado() {
		int resultados[] = new int[2];
		resultados[0] = (int) Math.floor(Math.random()*11);
		resultados[1] = (int) Math.floor(Math.random()*11);
		
		this.resultado = resultados;
	}

	public Arbitro[] getArbitros() {
		return arbitros;
	}

	public void setArbitros(Arbitro[] arbitros) {
		this.arbitros=arbitros;
	}



	public String toString() {
		
		String retorno="";
		
		retorno = "Partido:\n " + this.getNombre() +" \n"
				+ "Arbitro:\n";
		for( int i=0 ; i<arbitros.length ; i++ ) {
			retorno += " [" + i + "] " + arbitros[i].toString() + "\n";
		}
		retorno += "Resultado:\n " + equipos[0].getNombre() + ": " + resultado[0]
			   + "\n " + equipos[1].getNombre() + ": " + resultado[1] + " \n";
		
		return retorno;
	}
	
	


	
}
