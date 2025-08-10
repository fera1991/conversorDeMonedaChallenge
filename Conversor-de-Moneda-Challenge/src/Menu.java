import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    @Override
    public String toString() {
        return """
                
                ****************************************
                Sea bienvenido/a al Conversor de moneda =]
                
                Menú de Conversión de Monedas
                1. Convertir entre USD y otra moneda
                2. Convertir entre cualquier moneda
                3. Salir\
                
                Seleccione una opción (1-3):
                ****************************************
                """;
    }

    public OpcionMonedas convertirConUSD(Scanner scanner ,ArrayList<Moneda> listaMonedas){

        Moneda usd = new Moneda("USD", "Dólar estadounidense",  "América");

        int opcion = -1;

        ArrayList<Moneda> listaFiltrada = new ArrayList<>();
        for (Moneda moneda : listaMonedas) {
            if (!moneda.getSiglas().equals(usd.getSiglas())) {
                listaFiltrada.add(moneda);
            }
        }
        int contador = 1;
        for (int i = 0; i < listaFiltrada.size(); i++) {
                System.out.println((contador) + ". "+ usd + " =>> " + listaFiltrada.get(i));
                contador++;
                System.out.println((contador) + ". "+ listaFiltrada.get(i) + "=>"  + usd );
                contador++;
        }

        int maxOpcion = listaFiltrada.size()*2;

        opcion = validar_opcion(scanner,maxOpcion);

        int opcionArreglada = ((opcion-1)/2);
        if(opcion%2 != 0){

            Moneda moneda = listaFiltrada.get(opcionArreglada);
            return new OpcionMonedas(usd,moneda);
        }
        else{

            Moneda moneda = listaFiltrada.get(opcionArreglada);
            return new OpcionMonedas(moneda,usd);
        }
    }

    public OpcionMonedas cambiarEntreCualquierMoneda(Scanner scanner , ArrayList<Moneda> listaMonedas){

        int opcion = -1;
        System.out.println("Lista de la moneda Base:");
        for (int i = 0; i < listaMonedas.size(); i++) {
            System.out.println((i+1) + ". "+ listaMonedas.get(i));
        }

        int maxOpcion = listaMonedas.size();
        opcion = validar_opcion(scanner,maxOpcion);

        Moneda monedaOrigen = listaMonedas.get(opcion-1);

        ArrayList<Moneda> listaFiltrada = new ArrayList<>();
        for (Moneda moneda : listaMonedas) {
            if (!moneda.equals(monedaOrigen)) {
                listaFiltrada.add(moneda);
            }
        }

        for (int i = 0; i < listaFiltrada.size(); i++) {
            System.out.println((i+1) + ". "+ listaFiltrada.get(i));
        }

        maxOpcion = listaFiltrada.size();
        opcion = validar_opcion(scanner,maxOpcion);

        Moneda monedaObjetivo = listaFiltrada.get(opcion-1);

        return new OpcionMonedas(monedaOrigen,monedaObjetivo);

    }

    static int validar_opcion(Scanner scanner, int maxOpcion){

        int opcion = -1;

        while (true) {
            System.out.println("Elija una opción válida (1-" + maxOpcion + "):");
            try {
                opcion = scanner.nextInt();
                if (opcion < 1 || opcion > maxOpcion) {
                    System.out.println("Opción no válida. Debe estar entre 1 y " + maxOpcion + ". Intente de nuevo.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debe ingresar un número. Intente de nuevo.");
                scanner.next();
            }
        }

        return opcion;
    }

}
