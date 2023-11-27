
package com.unahur.parking;

/**
 *
 * @author andre
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ParkingManager {
    private ArrayList<String> matriculas;
    private String nombre;

    public ParkingManager(String nombre, int numPlazas) {
        this.nombre = nombre;
        this.matriculas = new ArrayList<>(numPlazas);
        for (int i = 0; i < numPlazas; i++) {
            matriculas.add(null);
        }
    }

    public void realizarEntrada(Scanner scanner) throws Exception {
        System.out.print("Introduzca la matrícula del coche: ");
        String matriculaEntrada = scanner.nextLine();
        System.out.print("Introduzca la plaza de aparcamiento: (Del 0 al 9)");
        int plazaEntrada = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de nextInt()

        entrada(matriculaEntrada, plazaEntrada);
        System.out.println("Entrada realizada con éxito.");
        System.out.println("Plazas totales: " + getPlazasTotales());
        System.out.println("Plazas ocupadas: " + getPlazasOcupadas());
        System.out.println("Plazas libres: " + getPlazasLibres());
    }

    public void realizarSalida(Scanner scanner) throws Exception {
        System.out.print("Introduzca la matrícula del coche que sale: ");
        String matriculaSalida = scanner.nextLine();

        int plazaLiberada = salida(matriculaSalida);
        System.out.println("Salida realizada con éxito.");
        System.out.println("Plazas totales: " + getPlazasTotales());
        System.out.println("Plazas ocupadas: " + getPlazasOcupadas());
        System.out.println("Plazas libres: " + getPlazasLibres());
        System.out.println("Plaza liberada: " + plazaLiberada);
    }

    public void entrada(String matricula, int plaza) throws Exception {
        if (matricula == null || matricula.length() < 4) {
            throw new Exception("Matrícula incorrecta");
        }

        if (plaza < 0 || plaza >= matriculas.size()) {
            throw new Exception("Plaza no válida");
        }

        if (matriculas.get(plaza) != null) {
            throw new Exception("Plaza ocupada");
        }

        if (matriculas.contains(matricula)) {
            throw new Exception("Matrícula repetida");
        }

        matriculas.set(plaza, matricula);
    }

    public int salida(String matricula) throws Exception {
        if (!matriculas.contains(matricula)) {
            throw new Exception("Matrícula no existente");
        }

        int plazaLiberada = matriculas.indexOf(matricula);
        matriculas.set(plazaLiberada, null);
        return plazaLiberada;
    }

    public int getPlazasTotales() {
        return matriculas.size();
    }

    public int getPlazasOcupadas() {
        int ocupadas = 0;
        for (String matricula : matriculas) {
            if (matricula != null) {
                ocupadas++;
            }
        }
        return ocupadas;
    }

    public int getPlazasLibres() {
        return matriculas.size() - getPlazasOcupadas();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n----------------\n");

        for (int i = 0; i < matriculas.size(); i++) {
            sb.append("Plaza ").append(i).append(": ");
            if (matriculas.get(i) == null) {
                sb.append("(vacía)");
            } else {
                sb.append(matriculas.get(i));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}