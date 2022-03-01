
package liga;

public class Partido {
	private boolean jugado=false;
	private Equipo local;
	private Equipo visitante;
	private int gLocal;
	private int gVisitante;
	private Arbitro arbitro;
	
	public void jugado() {
		this.jugado=true;
	}
	public boolean isJugado() {
		return jugado;
	}
	public void setJugado(boolean jugado) {
		this.jugado = jugado;
	}
	public Equipo getLocal() {
		return local;
	}
	public void setLocal(Equipo local) {
		this.local = local;
	}
	public Equipo getVisitante() {
		return visitante;
	}
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	public int getgLocal() {
		return gLocal;
	}
	public void setgLocal(int gLocal) {
		this.gLocal = gLocal;
	}
	public int getgVisitante() {
		return gVisitante;
	}
	public void setgVisitante(int gVisitante) {
		this.gVisitante = gVisitante;
	}
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	
	public String[] toStringArray() {
		String golesLocal="-";
		String golesVisitante="-";
		if(this.jugado) {
			golesLocal= Integer.toString(this.gLocal);
			golesVisitante=Integer.toString(this.gVisitante);
		}
		
		String[] retorno = {
				this.local.getNombre(),
				golesLocal,
				golesVisitante,
				this.visitante.getNombre(),
				this.arbitro.getApellidos()};
		return retorno;
	}

	@Override
	public String toString() {
		return this.local.getNombre()+" "+this.gLocal+":"
				+this.gVisitante+" "+this.visitante.getNombre()
				+", Arbitro: "+this.arbitro.getApellidos()+"\n";
	}

}
