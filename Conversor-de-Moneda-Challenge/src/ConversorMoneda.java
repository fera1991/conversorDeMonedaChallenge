import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorMoneda {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Consulta consulta = new Consulta();
        OpcionMonedas opcionMonedas = new OpcionMonedas();
        ArrayList<Moneda> listaMonedas = cargaMonedas();

        boolean salir = false;

        while (!salir) {
            Menu menu = new Menu();
            System.out.println(menu);

            try {
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la Opción 1");
                        opcionMonedas = menu.convertirConUSD(scanner, listaMonedas);
                        break;
                    case 2:
                        System.out.println("Has seleccionado la Opción 2");
                        opcionMonedas = menu.cambiarEntreCualquierMoneda(scanner, listaMonedas);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida, intenta de nuevo.");
                }
                if (!salir) {

                    System.out.println("Digita el valor que desea convertir:");
                    double cantidad = scanner.nextDouble();

                    PeticionMoneda resultado = consulta.obtenerConversion(opcionMonedas.getMonedaOrigen().getSiglas(),
                            opcionMonedas.getMonedaObjetivo().getSiglas(),
                            cantidad);
                    System.out.println("El valor " + cantidad + " [" + opcionMonedas.getMonedaOrigen().getSiglas() + "]" + " corresponde al valor final de =>>> " + resultado.conversion_result() + " [" + opcionMonedas.getMonedaObjetivo().getSiglas() + "]");

                }
            }
            catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debe ingresar un número. Intente de nuevo.");
                scanner.next();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        scanner.close();
    }


    public static ArrayList<Moneda> cargaMonedas() {

        ArrayList<Moneda> lista = new ArrayList<>(Arrays.asList(
                new Moneda("ARS", "Peso argentino", "América"),
                new Moneda("BOB", "Boliviano", "América"),
                new Moneda("BRL", "Real brasileño", "América"),
                new Moneda("CLP", "Peso chileno", "América"),
                new Moneda("COP", "Peso colombiano", "América"),
                new Moneda("USD", "Dólar estadounidense", "América")
        ));

        return lista;
    }
}
