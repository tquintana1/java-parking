/**
 @author Thiago Quitana
 **/

/*
 - Universidad Nacional de Hurligham
 - Trabajo final Introducción a Java
 - Ejercicio 3
*/

package com.unahur.parking;
import java.util.Scanner;

public class Parking {
    public static void main(String[] args) {
        // Crear objeto Parking
        ParkingManager parkingManager = new ParkingManager("Parking Centro", 10);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1) Entrada de coche");
            System.out.println("2) Salida de coche");
            System.out.println("3) Mostrar parking");
            System.out.println("4) Salir del programa");
            System.out.print("Seleccione una opción (1-4): ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt()

            try {
                switch (opcion) {
                    case 1:
                        parkingManager.realizarEntrada(scanner);
                        break;

                    case 2:
                        parkingManager.realizarSalida(scanner);
                        break;

                    case 3:
                        System.out.println(parkingManager.toString());
                        break;

                    case 4:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 4);

        scanner.close();
    }
}