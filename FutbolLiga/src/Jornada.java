
public class Jornada {

	Partido[] partidos;
	Arbitro[] arbitros = new Arbitro[3]; //Principal, linier y auxiliar
	String[] horarios;
	
	public Jornada() {
		// TODO Auto-generated constructor stub
	}

	public Partido[] getPartidos() {
		return partidos;
	}

	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}

	public Arbitro[] getArbitros() {
		return arbitros;
	}

	public void setArbitros(Arbitro[] arbitros) {
		this.arbitros = arbitros;
	}

	public String[] getHorarios() {
		return horarios;
	}

	public void setHorarios(String[] horarios) {
		this.horarios = horarios;
	}
	
	

}
