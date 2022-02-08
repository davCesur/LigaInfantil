public class ClasificacionNew {
    // Puntos que tiene el equipo
    private int puntos;
    // Partidos jugados por el equipo
    private int partidosJugados;
    // Partidos ganados por el equipo
    private int partidosGanados;
    // Partidos empatados por el equipo
    private int partidosEmpatados;
    // Partidos perdidos por el equipo
    private int partidosPerdidos;
    // Goles a favor del equipo
    private int golesFavor;
    // Goles en contra del equipo
    private int golesContra;
    
    Partido partido = new Partido();
    
    int resultado[] = partido.getResultado(); 

    /**
     * Constructor para objetos de clasificacion de equipo. Este objeto recoje las estadisticas de la clasificacion de la liga para un equipo.
     * Este constructor inicializa todas las variables a 0.
     */
    public ClasificacionEquipo()
    {
        // inicializamos variables
        this.puntos = puntos;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.golesFavor = 0;
        this.golesContra = 0;
    }

    public ClasificacionEquipo(int puntos, int partidosJugados, int partidosGanados, int partidosEmpatados, int partidosPerdidos, int golesFavor, int golesContra)
    {
    	// inicializamos variables
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosEmpatados = partidosEmpatados;
        this.partidosPerdidos = partidosPerdidos;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
    }

    /**
     * Suma las estadisticas pasadas como parametro a este objeto clasificacion.
     * @param sumaEstadisticas Estadisticas a sumar a este objeto.
     */
    public void sumaEstadisticas(ClasificacionEquipo sumaEstadisticas)
    {
        puntos += sumaEstadisticas.getPuntos();
        partidosJugados += sumaEstadisticas.getPartidosJugados();
        partidosGanados += sumaEstadisticas.getPartidosGanados();
        partidosEmpatados += sumaEstadisticas.getPartidosEmpatados();
        partidosPerdidos += sumaEstadisticas.getPartidospartidosEmpatadosrdidos();
        golesFavor += sumaEstadisticas.getGolesAFavor();
        golesContra += sumaEstadisticas.getGolesEnContra();
    }

    /**
     * Devuelve los puntos del equipo
     * @return los puntos del equipo
     */
    public int getPuntos()
    {
        return puntos;
    }

    /**
     * Devuelve los partidos jugados del equipo
     * @return los partidos jugados del equipo
     */
    public int getPartidosJugados()
    {
        return partidosJugados;
    }

    /**
     * Devuelve los partidos ganados del equipo
     * @return los partidos ganados del equipo
     */
    public int getPartidosGanados()
    {
        return partidosGanados;
    }

    /**
     * Devuelve los partidos empatados del equipo
     * @return los partidos empatados del equipo
     */
    public int getPartidosEmpatados()
    {
        return partidosEmpatados;
    }

    /**
     * Devuelve los partidos partidosEmpatadosrdidos del equipo
     * @return los partidos partidosEmpatadosrdidos del equipo
     */
    public int getPartidospartidosEmpatadosrdidos()
    {
        return partidosPerdidos;
    }

    /**
     * Devuelve los goles a favor del equipo
     * @return los goles a favor del equipo
     */
    public int getGolesAFavor()
    {
        return golesFavor;
    }

    /**
     * Devuelve los goles en contra del equipo
     * @return los goles en contra del equipo
     */
    public int getGolesEnContra()
    {
        return golesContra;
    }

    /**
     * Devuelve la diferencia de goles a favor y en contra del equipo
     * @return la diferencia de goles a favor y en contra del equipo
     */
    public int getDiferenciaDeGoles()
    {
        return (golesFavor - golesContra);
    }
    
    /**
     * Devuelve la informacion de la clasificacion del equipo
     * @return un String con la informacion de la clasificacion del equipo
     */
    public String toString()
    {
        return (puntos + "\t" + partidosJugados + "\t" + + partidosGanados + "\t" + partidosEmpatados + "\t" + partidosPerdidos + "\t" + golesFavor + "\t" + golesContra + "\t" + getDiferenciaDeGoles());
    }
}
