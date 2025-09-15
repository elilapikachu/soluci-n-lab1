//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertar(5);
        lista.insertar(3);
        lista.insertar(8);
        lista.insertar(1);
        lista.insertar(4);

        lista.ordenarMenorAMayor();
        lista.recorre();
    }
}