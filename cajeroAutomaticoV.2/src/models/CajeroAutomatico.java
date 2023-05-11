package models;

import java.util.Scanner;

/**
 *
 * @author chanp
 */
public class CajeroAutomatico {

        private CuentaBancaria cuenta;
        private static int ultimoRegistro;

    public CajeroAutomatico() {
        cuenta = new CuentaBancaria(123456789, 2000);
        ultimoRegistro = 0;
    }

    public boolean validarNIP(String nip) {
        return nip.equals("1234");
    }

    public void mostrarMenu() {
        System.out.println("\u001B[36m" + "ACCESO CONCEDIDO");
        Scanner leer = new Scanner(System.in);
        String opcion = "0";

        while (!opcion.equals("5")) {
            System.out.println("\n\nCAJERO BCA");
            System.out.println("1. CONSULTAR SALDO");
            System.out.println("2. REALIZAR UN DEPOSITO");
            System.out.println("3. RETIRAR EFECTIVO");
            System.out.println("4. NUEVO CLIENTE");
            System.out.println("5. SALIR");
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
                    System.out.println("Nuevo cliente");
                    crearCliente();
                    break;
                    
                case "5":
                    System.out.println("Gracias por utilizar el cajero BCA");

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            
        }
    }
    public static final String ANSI_CYAN = "\u001B[36m";
    private void crearCliente() {
        System.out.println(ANSI_CYAN + "Funciones de banca movil proximamente");
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresar nombre del cliente");
        String nombre = leer.nextLine();
        System.out.println("Ingresar telefono");
        String telefono = leer.nextLine();
        System.out.println("Ingresar direccion");
        String direccion = leer.nextLine();
        System.out.println("Ingresar correo electronico");
        String correoElectronico = leer.nextLine();
        
        Cliente cliente = new Cliente(nombre, telefono, direccion, correoElectronico);
        cliente.generarIP(ultimoRegistro);
        ultimoRegistro++;
        cliente.generarNumeroCuenta();
        cliente.registrarNIP();
        
        System.out.println("Cliente registrado exitosamente");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println("Direccion: " + cliente.getDireccion());
        System.out.println("Correo electronico: " + cliente.getCorreoElectronico());
        System.out.println("IP generada: " + ultimoRegistro);
        System.out.println("Numero de cuenta: " + cliente.getNumeroCuenta());
        
    }
}