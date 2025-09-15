//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertar(12);
        lista.insertar(20);
        lista.insertar(7);
        lista.insertar(65);
        lista.insertar(3);
        lista.insertar(4);

       // lista.ordenarMenorAMayor();
        lista.recorre();
        lista.eliminarNodosDominados();
        System.out.println("La lista despues de eliminar nodos eliminados:");
        lista.recorre();
    }
}