package reto1;

public class MainReto1 {
    public static void main(String[] args) {
        SIMCard cliente = new SIMCard("3015328969");
        System.out.println(cliente.toString());
        cliente.recargarSaldo(50000);
        System.out.println(cliente.toString());
        cliente.comprarDatos(12);
        System.out.println(cliente.toString());
        cliente.consumirDatos(3);
        System.out.println(cliente.toString());
        cliente.gestionarEncendidoCelular();
        cliente.llamar(125);
        System.out.println(cliente.toString());
        cliente.gestionarModoAvion();
        cliente.gestionarDatos();
        System.out.println(cliente.toString());
        cliente.gestionarModoAvion();
        cliente.gestionarDatos();
        System.out.println(cliente.toString());
        cliente.consumirDatos(3);
        System.out.println(cliente.toString());
        cliente.gestionarEncendidoCelular();
        System.out.println(cliente.toString());
    }
}
