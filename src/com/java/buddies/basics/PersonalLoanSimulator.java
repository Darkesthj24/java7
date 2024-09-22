package com.java.buddies.basics;




import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <b>Caso de uso: <b/> Simulador de préstamo personal
 * <br>
 * <b>Reglas de negocio: <b/>
 * - Un cliente puede simular un préstamo personal indicando el monto, plazo y tipo de cliente (nuevo o recurrente).
 * - La tasa de interés varía según el tipo de cliente:
 *   - Nuevo cliente: 5% anual
 *   - Cliente recurrente: 3% anual
 * - El monto del préstamo debe ser positivo.
 * - El plazo debe ser entre 1 y 10 años.
 * - Pago total = monto × (1 + tasa de interés)^años
 * <br>
 * <b>Criterios de aceptación: <b/> La aplicación debe calcular y mostrar el total a pagar al final del plazo.
 */
public class PersonalLoanSimulator {

    private static final String NEW_USER = "N";
    private static final String FREQUENT_USER = "R";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //inputs & validations
        Map<String, Double> interestRates = new HashMap<>();
        interestRates.put(NEW_USER, 0.05);
        interestRates.put(FREQUENT_USER, 0.03);

        System.out.print("Ingrese el monto del préstamo: ");
        double loanAmount = scanner.nextDouble();

        if (loanAmount <= 0) {
            throw new IllegalArgumentException("El monto del préstamo debe ser positivo.");
        }

        System.out.print("Ingrese el plazo del préstamo (en años, 1-10): ");
        int years = scanner.nextInt();

        if (years < 1 || years > 10) {
            throw new IllegalArgumentException("El plazo debe ser entre 1 y 10 años.");
        }

        System.out.print("Ingrese el tipo de cliente (nuevo: N | recurrente: R): ");
        String customerType = scanner.next();

        if (!interestRates.containsKey(customerType)) {
            throw new IllegalArgumentException("Tipo de cliente inválido.");
        }

        double interestRate = interestRates.get(customerType);

        //process
        double totalToPay = loanAmount * Math.pow(1 + interestRate, years);

        //output
        System.out.printf("Total a pagar al final del plazo: %.2f\n", totalToPay);
    }
}



