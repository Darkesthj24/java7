package com.java.buddies.basics;

import java.util.Scanner;

/**
 * <b>Caso de uso: <b/> Selección de Clientes VIP
 * <br>
 * <b>Reglas de negocio: <b/>
 * - Un cliente se considera VIP si tiene más de un cierto monto en su cuenta.
 * - La categoría VIP puede ser "Plata", "Oro" o "Platino" dependiendo del saldo:
 *   - Plata: más de 10,000 y hasta 50,000
 *   - Oro: más de 50,000 y hasta 100,000
 *   - Platino: más de 100,000
 * <br>
 * <b>Criterios de aceptación: <b/> La aplicación debe determinar y mostrar la categoría VIP del cliente.
 */
public class VIPCustomerSelector {

    private static final String PLATINUM = "Platino";
    private static final String GOLD = "Oro";
    private static final String SILVER = "Plata";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // inputs & validations
        System.out.print("Ingrese el saldo de la cuenta del cliente: ");
        double accountBalance = scanner.nextDouble();

        if (accountBalance < 0)
            throw new IllegalArgumentException("El saldo debe ser positivo.");

        // process
        String vipCategory;
        if (accountBalance > 100000) {
            vipCategory = PLATINUM;
        } else if (accountBalance > 50000) {
            vipCategory = GOLD;
        } else if (accountBalance > 10000) {
            vipCategory = SILVER;
        } else {
            throw new IllegalArgumentException("El cliente no tiene una categoría VIP");
        }

        // output
        System.out.println("La categoría VIP del cliente es: " + vipCategory);
    }
}
