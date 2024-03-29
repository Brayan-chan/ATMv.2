package cajeroautomaticov.pkg2;
import java.util.Scanner;
import models.CajeroAutomatico;
import models.CuentaBancaria;
import models.Cliente;
/**
 *
 * @author chanp
 */
public class CajeroAutomaticoV2 {
        //Colores
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";
        
    public static void principalMain () {
        System.out.println("      CAJERO AUTOMATICO BCA");
        System.out.println("      WELCOME - BIENVENIDO\n");
        Scanner leer = new Scanner(System.in);
        System.out.println(ANSI_RED + "     SOLO PERSONAL AUTORIZADO");
        System.out.println("Ingresa tu TARJETA - CODIGO - CLABE\n");
        String tarjeta = leer.next();
        System.out.println("Ingresa el NIP para acceder a la cuenta");
        String NIP = leer.next();
        
        CajeroAutomatico cajero = new CajeroAutomatico();
        
        if (cajero.validarNIP(NIP)) {
            cajero.mostrarMenu();
        } else {
            System.out.println(ANSI_RED + "NIP INCORRECTO");
            principalMain();
        }
    }
        

   
    public static void main(String[] args) {
    principalMain();
        
        
        /*
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
    } 
    
}