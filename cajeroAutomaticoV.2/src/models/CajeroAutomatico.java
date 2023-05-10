package models;

import java.util.Scanner;

/**
 *
 * @author chanp
 */
public class CajeroAutomatico {

        private CuentaBancaria cuenta;

    public CajeroAutomatico() {
        cuenta = new CuentaBancaria(123456789, 2000);
    }

    public boolean validarNIP(String nip) {
        return nip.equals("1234");
    }

    public void mostrarMenu() {
        Scanner leer = new Scanner(System.in);
        String opcion = "0";

        while (!opcion.equals("4")) {
            System.out.println("\n\nCAJERO BCA");
            System.out.println("1. CONSULTAR SALDO");
            System.out.println("2. REALIZAR UN DEPOSITO");
            System.out.println("3. RETIRAR EFECTIVO");
            System.out.println("4. SALIR");
            opcion = leer.next();

            switch (opcion) {
                case "1":
                    System.out.println("El saldo de la tarjeta es: " + cuenta.getSaldo());
                    break;

                case "2":
                    System.out.println("Depositar efectivo");
                    System.out.println("Ingrese el monto a depositar");
                    double deposito = leer.nextDouble();
                    if (deposito > 0) {
                        cuenta.depositar(deposito);
                    } else {
                        System.out.println("ERROR. Monto incorrecto");
                    }
                    break;

                case "3":
                    System.out.println("Retirar efectivo");
                    System.out.println("Ingrese el monto a retirar");
                    double montoRetirar = leer.nextDouble();
                    if (montoRetirar <= cuenta.getSaldo()) {
                        cuenta.retirar(montoRetirar);
                    } else {
                        System.out.println("No se puede retirar un monto mayor al saldo");
                    }
                    break;

                case "4":
                    System.out.println("Gracias por utilizar el cajero BCA");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }
}
