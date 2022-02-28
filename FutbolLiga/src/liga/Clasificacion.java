
package liga;

public class Clasificacion {
	private EquipoClasificacion [] tabla;

	public Clasificacion( Equipo[] equipos, Calendario calendario) {
		generarClasificacion(equipos, calendario);
	}
	
	public void generarClasificacion( Equipo[] equipos, Calendario calendario) {
		//Crear la tabla
		int numeroEquipos = equipos.length;

		this.tabla = new EquipoClasificacion[numeroEquipos];
		for(int i=0;i<numeroEquipos;i++) {
			this.tabla[i] = new EquipoClasificacion();
			this.tabla[i].setEquipo(equipos[i]);
		}
		//Rellenarla
		Jornada[] jornadas = calendario.getJornadas();
		for (Jornada jor : jornadas) {
			if (jor.isTerminada()) {
				Partido[] partidos = jor.getPartidos(); 
				for (Partido par: partidos) {
					Equipo local = par.getLocal();
					Equipo visitante = par.getVisitante();
					//Buscar a los equipos en la tabla de clasificacion
					int contador=0;
					EquipoClasificacion localClas = this.tabla[contador];
					//Busco al local
					while (localClas.getEquipo()!=local) {
						contador++;
						localClas=this.tabla[contador];
					}
					contador=0;
					EquipoClasificacion visitClas = this.tabla[contador];
					//Busco al visitante
					while (visitClas.getEquipo()!=visitante) {
						contador++;
						visitClas=this.tabla[contador];
					}
					//Asignamos los valores
					int golesLocales=par.getgLocal();
					int golesVisitantes=par.getgVisitante();

					localClas.addGolesFavor(golesLocales);
					localClas.addGolesContra(golesVisitantes);

					visitClas.addGolesFavor(golesVisitantes);
					visitClas.addGolesContra(golesLocales);

					if (golesLocales>golesVisitantes) {//Gana local
						localClas.addVictoria();
						visitClas.addDerrota();
					}else if (golesLocales<golesVisitantes) {//Gana visitante
						localClas.addDerrota();
						visitClas.addVictoria();
					}else {//Empate
						localClas.addEmpate();
						visitClas.addEmpate();
					}
				}
			}
		}

		ordenar();



	}
	private void ordenar() {
		//Ordenación por bubbleSort

		int n = this.tabla.length;  
		EquipoClasificacion temp = null;  
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(vaDespues(tabla[j-1],tabla[j])){  
					//swap elements  
					temp = tabla[j-1];  
					tabla[j-1] =tabla[j];  
					tabla[j] = temp;  
				}  

			}  
		}
	}
	private boolean vaDespues(EquipoClasificacion equipo1, EquipoClasificacion equipo2) {
		
		//Primer Criterio Puntos
		if (equipo1.getPuntos()<equipo2.getPuntos()) {
			return true;
		}else if (equipo1.getPuntos()>equipo2.getPuntos()) {
			return false;
		}else{ //Segundo Criterio. A igualdad de puntos, diferencia goles
			if (equipo1.getdGoles()<equipo2.getdGoles()) {
				return true;
			}else if (equipo1.getdGoles()>equipo2.getdGoles()) {
				return false;
			}else {//Tercer Critero. Goles a favor
				if (equipo1.getgFavor()<equipo2.getgFavor()) {
					return true;
				}else if (equipo1.getgFavor()>equipo2.getgFavor()) {
					return false;
				}
			}
			//Ultimo criterio. El primero baja y punto.
			return true;
			
		}

	}
	
	public String[][] toStringArray() {
		String[][] retorno = new String[tabla.length][];
		for (int i=0; i<tabla.length; i++) {
			
			//Añadimos la numeración en primer lugar
			String[] equipoTemp = tabla[i].toStringArray();
			String[] tablaTemp = new String[equipoTemp.length+1];
			tablaTemp[0] = Integer.toString(i+1);
			for (int j=0; j<equipoTemp.length; j++) {
				tablaTemp[j+1] = equipoTemp[j];
			}
			
			retorno[i] = tablaTemp;
		}
		return retorno;
	}
	
	@Override
	public String toString() {
		String cadena = "Pos\tEquipo\t\t\t\t\t\t"+"J\t"+"G\t"+"P\t"+"E\t"+"GF\t"+"GC\t"+"DG\t"+"Pts\n";
		for (int i=0; i<tabla.length; i++) {
			cadena+=(i+1)+"\t"+tabla[i];
		}
		return cadena;
	}

}
