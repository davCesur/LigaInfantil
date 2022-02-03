
public class Liga {
	
	private String nombre;
	private Equipo[] equipos;
	private Calendario calendario;
	private Arbitro[] arbitros; //array de 3 (principal, linier y asistente)
	private Clasificacion clasificacion;
	
	

	
	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Equipo[] getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipo[] equipos) {
		//Crear una Lista de Equipos
		int numeroEquipos = (int) (Math.floor(Math.random()*3)+4)*2; // Generamos un número par de equipos
		
		if( numeroEquipos%2!=0 ) {
			//El número de equipos es impar
			ui.print("Error: El númeor de equipos a generar es impar");
			System.exit(1);
		}
		
		String [] nombreBarrios = {"El Candado", "Huelin", "Tiro Pichón", "Rincón de la Victoria", "La Rosaleda", "Torremolinos",
				"Velez Málaga","Cerrado de Calderon", "El Puerto de la Torre", "Bresca", "Mezquitilla", "Teatinos", "Motril",
				"Centro","Santa Paula", "El Palo", "Los Corazones", "Las Delicias", "Recogidas","Nueva Málaga", "Casas Blancas",
				"La Palmilla","Los Asperones","Campanillas","La Corta"};
		String [] mascotas = {"Los Pollos", "Los Araclanes", "Los Limones", "Los Delfines", "Los Chanquetes", "Los Gatitos",
								"Los Boquerones", "Los Toros", "Los Perritos", "Los Halcones", "Los Ornitorrincos", "Los Caracoles",
								"Los Palomos Cojos", "Los Heterosaurios", "Las Tortugas Ninjas", "Los Pintarrojas"};

		Equipo [] listaEquipos= new Equipo[numeroEquipos];
		
		for (int i=0; i<numeroEquipos; i++) {
			
			//Creamos Equipo
			Equipo equipo = new Equipo();
			
			//Edad (de 8 a 15 años)
			int edad = (int) Math.floor(Math.random()*8)+8;
			equipo.setEdadJugadores(edad);
			
			// #### Generamos el nombre y club
			//Elegimos random un nombre y una mascota de las listas respectivas.
			int numero = (int) Math.floor(Math.random()*nombreBarrios.length);
			String barrio= nombreBarrios[numero];
			numero = (int) Math.floor(Math.random()*mascotas.length);
			String mascota= mascotas[numero];

			//Definimos el club en base al nombre del barrio
			equipo.setClub(barrio+" F.C.");
			
			//Las pegamos con un "de" en medio
			String nombre;
			if (barrio.startsWith("El ")) {
				barrio=barrio.substring(3);
				nombre = mascota + " del "+ barrio;
			}else {
				nombre = mascota + " de "+ barrio;
			}
			
			equipo.setNombre(nombre);
			
			//  #####  Meter el equipo en el array de equipos
			
			listaEquipos[i]=equipo;
			
			
		
		}
		
		this.equipos = listaEquipos;
		
	}


	public Calendario getCalendario() {
		return calendario;
	}




	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}




	public Arbitro[] getArbitros() {
		return arbitros;
	}

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




	public Clasificacion getClasificacion() {
		return clasificacion;
	}




	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}





}
