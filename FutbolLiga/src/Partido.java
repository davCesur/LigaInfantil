
/**
 * ######### PENDIENTE DE CALENDARIO
 */

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
	
	/**
	 * Constructor
	 */
	public Partido() {
		setArbitros();
		setResultado();
	}

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

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public int[] getResultado() {
		return resultado;
	}

	public void setResultado() {
		int resultados[] = new int[2];
		resultados[0] = (int) Math.floor(Math.random()*10);
		resultados[1] = (int) Math.floor(Math.random()*10);
		
		this.resultado = resultados;
	}

	public Arbitro[] getArbitros() {
		return arbitros;
	}

	/**
	 * Establece un array de 3 árbitros (Principal, linier y asistente).
	 * @return array generado.
	 */
	public void setArbitros() {
		//Listado de Nombres, Apellidos, Posiciones para generador random
		String[] nombres = {"Antonio", "Pepito", "Alejandra", "Ismael", "Hugo", "Oliver","Kalesi",
				"Ingrid","Astrid","Indira","Jenny","Jessi","Vane","Joel","Bruno",
				"Sasha","Billie","Masha","Pingu"};
		String[] apellidos = {"Messi", "Vinicius", "Cristiano", "Ronaldo", "Piqué","Bale (lesionado)",
				"Amunike","N'kono","Butragueño","Sanchís","Neymar","Batistuta","Maradona",
				"Pelé","Beckenbauer"};
		
		Arbitro[] arbitros = new Arbitro[3];
		
		for( int i=0 ; i<arbitros.length ; i++ ) {
			
			Arbitro arbitro = new Arbitro();
			
			//Nombre
			int numero = (int) Math.floor(Math.random()*nombres.length);
			String nombre = nombres[numero];
			arbitro.setNombre(nombre);

			//Apellidos
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido1 = apellidos[numero];
			numero = (int) Math.floor(Math.random()*apellidos.length);
			String apellido2 = apellidos[numero];
			arbitro.setApellidos(apellido1+" "+apellido2);
			
			//Edad
			int edad = (int) Math.floor(Math.random()*47)+18;
			arbitro.setEdad(edad);
			//Licencia
			int licencia = (int) Math.floor(Math.random()*100000);
			arbitro.setLicencia(licencia);
			
			arbitros[i] = arbitro;
		}
		
		this.arbitros = arbitros;
	}


	public String toString() {
		
		String retorno="";
		
		retorno = "Partido:\n " + this.getNombre() +" \n"
				+ "Arbitro:\n";
		for( int i=0 ; i<arbitros.length ; i++ ) {
			retorno += " [" + i + "] " + arbitros[i].toString() + "\n";
		}
		retorno += "Resultado:\n " + equipos[0].getNombre() + ": " + resultado[0]
			   + "\n " + equipos[1].getNombre() + ": " + resultado[1] + " \n"
				+ "Fecha:\n " + calendario.toString() +" \n\n ";
		
		return retorno;
	}
	
	


	
}
