package models;

import java.util.Scanner;

/**
 *
 * @author chanp
 */
public class Cliente {
    private String nombre;
    private String telefono;
    private String direccion;
    private String correoElectronico;
    private int numeroCuenta;
    private int nip;
    
    public Cliente(String nombre, String telefono, String direccion, String correoElectronico) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public void generarNumeroCuenta() {
        long cuenta = (long) (Math.random() * 9000000000000000L) + 1000000000000000L;
        numeroCuenta = (int) cuenta;
    }
    
    public void registrarNIP() {
        Scanner leer = new Scanner(System.in);
        boolean nipValido = false;
        
        while (!nipValido) {
            System.out.println("Ejemplo: 1000");
            System.out.println("Registra tu NIP (4 digitos):");
            nip = leer.nextInt();
            
            if (nip >= 1000 && nip <= 9999) {
                nipValido = true;
            } else {
                System.out.println("El NIP debe ser de 4 digitos\nINTENTELO DE NUEVO");
            }
        }
    }
    
    public void generarIP(int registro) {
        System.out.println("Generar IP (presione ENTER)");
        Scanner leer = new Scanner(System.in);
        leer.nextLine();
        System.out.println("IP generada: " + registro);
    }
    


    
    
    
    
}



/*package cajeroautomaticov.pkg2;
import java.util.Scanner;

/**
 *
 * @author chanp
 */
/*public class CajeroAutomaticoV2 {

   
    public static void main(String[] args) {
        System.out.println("   CAJERO AUTOMATICO BCA");
        System.out.println("   WELCOME - BIENVENIDO\n");
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa tu TARJETA - CODIGO - CLABE\n");
        String tarjeta = leer.next();
        System.out.println("Ingresa el NIP para acceder a la cuenta");
        String NIP = leer.next();
        
        CajeroAutomatico cajero = new CajeroAutomatico();
        
        if (cajero.validarNIP(NIP)) {
            cajero.mostrarMenu();
        } else {
            System.out.println("NIP INCORRECTO");
        }
        
         }
}

class CajeroAutomatico {
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

class CuentaBancaria {
    private int numeroCuenta;
    private double saldo;

    public CuentaBancaria(int numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        saldo -= monto;
    }
}

class Cliente {
    private String nombre;
    private String direccion;
    private String tarjetaCLABE;
    
    public Cliente(String nombre, String direccion, String tarjetaCLABE) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tarjetaCLABE = tarjetaCLABE;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public String getTarjetaCLABE() {
        return tarjetaCLABE;
    }
    
    public void setTarjetaCLABE(String tarjetaCLABE) {
        this.tarjetaCLABE = tarjetaCLABE;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", direccion=" + direccion + ", tarjetaCLABE=" + tarjetaCLABE + '}';
    }
    
    
    
}

    
        System.out.println("   CAJERO AUTOMATICO ATM");
        System.out.println("   WELCOME - BIENVENIDO\n");
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa tu tarjeta-codigo-CLABE\n");
        String tarjeta = leer.next();
        System.out.println("Ingresa tu NIP para acceder a la cuenta");
        String NIP = leer.next();
        if (NIP.equals("1234")){
            
            double saldo = 2000;
            String opcion = "0";
            
            while (!opcion.equals("4")){
                System.out.println("\n\nCAJERO BCA");
                System.out.println("1. CONSULTAR SALDO");
                System.out.println("2. REALIZAR UN DEPOSITO");
                System.out.println("3. RETIRAR EFECTIVO");
                System.out.println("4. SALIR");
                opcion = leer.next();
                switch (opcion) {
                    case "1": {
                        System.out.println("El saldo de la tarjeta es: "+ Double.toString(saldo));
                        break;
                    }
                    
                    case "2": {
                        System.out.println("Depositar efectivo");
                        System.out.println("Ingrese el monto a depositar");
                        double deposito=leer.nextDouble();
                        if (deposito > 0) {
                            saldo = saldo + deposito;
                        }
                        else {
                            System.out.println("ERROR. Monto incorrecto");
                        }
                        break;
                    }
                    case "3": {
                        System.out.println("Retirar efectivo");
                        double montoRetirar;
                        montoRetirar = leer.nextDouble();
                        if (montoRetirar <= saldo) {
                            saldo = saldo - montoRetirar;
                        } else {
                            System.out.println("No se puede retirar un monto mayor al saldo");
                        }
                        break;
                    }
                    case "4": {
                        System.out.println("Gracias por utilizar el cajero BCA");
                        break;
                    }
                    default: {
                        System.out.println("Opcion incorrecta");
                        break;
                    }
                }
            }
            
        } else {
            System.out.println("NIP INCORRECTO");
        }
*/
    

