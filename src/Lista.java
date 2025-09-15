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
    public Nodo ultimoNodo(){
        return  this.ultimo;
    }

    private Nodo anterior(Nodo nodo) {
        Nodo iterador = primerNodo();
        Nodo nodoAnt = null;

        while (iterador != null && iterador != nodo) {
            nodoAnt = iterador;
            iterador = iterador.obtenerLiga();
        }
        return nodoAnt;
    }

    public Nodo buscaDondeInsertar(int candidato) {
        Nodo iterador = primerNodo();
        Nodo nodoAnt = null;

        while (iterador != null &&  iterador.obtenerDato() < candidato) {
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
        Nodo nodoAnterior = ultimoNodo();
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

    public Nodo buscarDato(int dato) {
        Nodo iterador = primerNodo();

        while (iterador != null && (int) iterador.obtenerDato() != dato) {
            iterador = iterador.obtenerLiga();
        }
        return iterador;
    }


    public void desconectar(Nodo nodoADesconectar) {
        Nodo nodoAnterior = anterior(nodoADesconectar);

        if (nodoADesconectar == primero) {
            primero = primero.obtenerLiga();
            if (primero == null) {
                ultimo = null;
            }
        } else {
            nodoAnterior.asignarLiga(nodoADesconectar.obtenerLiga());
            if (nodoADesconectar == ultimo) {
                ultimo = nodoAnterior;
            }
        }
    }

    public void borrar(int datoABorrar) {
        Nodo nodoABorrar = buscarDato(datoABorrar);
        if (nodoABorrar == null) {
            throw new RuntimeException("Dato inexistente en la lista");
        }
        desconectar(nodoABorrar);
    }

    public void ordenarMenorAMayor() {
        if (primerNodo() == null || primerNodo().obtenerLiga() == null) {
            throw new RuntimeException("La lista está vacía o tiene un solo elemento");
        }

        Nodo iterador = primerNodo();
        while (iterador != null) {
            Nodo mayor = iterador.obtenerLiga();
            Nodo menor = iterador;

            while (mayor != null) {
                if (mayor.obtenerDato() < menor.obtenerDato()) {
                    menor = mayor;
                }
                mayor = mayor.obtenerLiga();
            }

            if (menor != iterador) {
                int temp = iterador.obtenerDato();
                iterador.asignarDato(menor.obtenerDato());
                menor.asignarDato(temp);
            }

            iterador = iterador.obtenerLiga();
        }
    }


    public void eliminarNodosDominados() {
        if (primerNodo() == null || primerNodo().obtenerLiga() == null) {
            throw new RuntimeException("La lista esta vacia o tiene un solo elemento");
        }

        Nodo aux = primerNodo();
        Nodo iterador = aux.obtenerLiga();

        while (iterador != null && aux != null) {
            System.out.println("Iterador actual: " + iterador.obtenerDato());
            System.out.println("Aux actual: " + aux.obtenerDato());
            if( aux.obtenerDato() <  iterador.obtenerDato()){
                System.out.println("Valor eliminado de la lista de nodos:  " + aux.obtenerDato());
                desconectar(aux);
                aux = iterador;
            } else {
                aux = aux.obtenerLiga();
            }

            iterador = iterador.obtenerLiga();
        }


    }
}
