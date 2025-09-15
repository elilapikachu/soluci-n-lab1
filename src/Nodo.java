
public class Nodo {

    private int dato;
    private Nodo liga;

    public Nodo(int dato) {
        this.dato = dato;
        this.liga = null;
    }
    public void asignarLiga(Nodo nodoALigar){
        this.liga = nodoALigar;
    }
    public void asignarDato(int dato){
        this.dato = dato;
    }
    public Nodo obtenerLiga(){
        return this.liga;
    }
    public int obtenerDato() {
        return this.dato;
    }


}
