public class Lista {
    private Nodo primero;
    private Nodo ultimo;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }
    public  boolean esVacia(){
        return this.primero == null;
    }
    public Nodo primerNodo(){
        return this.primero;
    }
//    public Nodo ultimoNodo(){
//        return  this.ultimo;
//    }

//    private Nodo anterior(Nodo nodo) {
//        Nodo iterador = primerNodo();
//        Nodo nodoAnt = null;
//
//        while (iterador != null && iterador != nodo) {
//            nodoAnt = iterador;
//            iterador = iterador.obtenerLiga();
//        }
//        return nodoAnt;
//    }

    public Nodo buscaDondeInsertar(int candidato) {
        Nodo iterador = primerNodo();
        Nodo nodoAnt = null;

        while (iterador != null && (int) iterador.obtenerDato() < candidato) {
            nodoAnt = iterador;
            iterador = iterador.obtenerLiga();
        }
        return nodoAnt;
    }

    public void conectar(Nodo nodoAConectar, Nodo nodoAnterior) {
        if (nodoAnterior == null) {
            nodoAConectar.asignarLiga(primero);
            if (primero == null) {
                ultimo = nodoAConectar;
            }
            primero = nodoAConectar;
        } else {
            nodoAConectar.asignarLiga(nodoAnterior.obtenerLiga());
            nodoAnterior.asignarLiga(nodoAConectar);
            if (nodoAnterior.equals(ultimo) ) {
                ultimo = nodoAConectar;
            }
        }
    }

    public void insertar(int dato) {
        Nodo nodoAnterior = buscaDondeInsertar(dato);
        Nodo nuevoNodo = new Nodo(dato);
        conectar(nuevoNodo, nodoAnterior);
    }

    public void recorre() {
        Nodo iterador = primerNodo();
        while (iterador != null) {
            System.out.println(iterador.obtenerDato());
            iterador = iterador.obtenerLiga();
        }
    }

//    public Nodo buscarDato(int dato) {
//        Nodo iterador = primerNodo();
//
//        while (iterador != null && (int) iterador.obtenerDato() != dato) {
//            iterador = iterador.obtenerLiga();
//        }
//        return iterador;
//    }
//
//
//    public void desconectar(Nodo nodoADesconectar) {
//        Nodo nodoAnterior = anterior(nodoADesconectar);
//
//        if (nodoADesconectar == primero) {
//            primero = primero.obtenerLiga();
//            if (primero == null) {
//                ultimo = null;
//            }
//        } else {
//            nodoAnterior.asignarLiga(nodoADesconectar.obtenerLiga());
//            if (nodoADesconectar == ultimo) {
//                ultimo = nodoAnterior;
//            }
//        }
//    }
//
//    public void borrar(int datoABorrar) {
//        Nodo nodoABorrar = buscarDato(datoABorrar);
//        if (nodoABorrar == null) {
//            throw new RuntimeException("Dato inexistente en la lista");
//        }
//        desconectar(nodoABorrar);
//    }

    public void ordenarMenorAMayor() {
        if (primerNodo() == null || primerNodo().obtenerLiga() == null) {
            throw new RuntimeException("La lista esta vacia o tiene un solo elemento");
        }
        Nodo iterador = primerNodo();
        while (iterador != null) {
            Nodo mayor = iterador;
            Nodo aux = iterador.obtenerLiga();
            while (aux != null) {
                if ( aux.obtenerDato() > mayor.obtenerDato()) {
                    mayor = aux;
                    System.out.println("Mayor actual: " + mayor.obtenerDato());
                }
                aux = aux.obtenerLiga();
            }
            iterador = iterador.obtenerLiga();
        }
    }
}
