package com.java.buddies.basics;

import java.util.Scanner;
/**
 * <b>Caso de uso: <b/> Verificación de límite de retiro en cajero automático
 * <br>
 * <b>Reglas de negocio: <b/>
 * - Los clientes pueden retirar dinero de un cajero automático, pero hay un límite máximo de retiro por transacción.
 * - El límite de retiro depende del tipo de cuenta:
 *   - Cuenta Estándar: Límite de retiro de 500 dólares.
 *   - Cuenta Premium: Límite de retiro de 1000 dólares.
 * - Si el monto a retirar supera el límite, la transacción debe ser rechazada.
 * - El monto a retirar debe ser un valor positivo.
 * <br>
 * <b>Criterios de aceptación: <b/> La aplicación debe determinar si el retiro puede realizarse basado en el tipo de cuenta y el monto a retirar.
 */

public class ATMWithdrawalChecker {
    private static final String STANDARD = "Estandar";
    private static final String PREMIUM = "Premium";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // inputs & validations
        System.out.print("Ingrese el monto a retirar: ");
        double amountToWithdraw = scanner.nextDouble();

        if (amountToWithdraw <= 0)
            throw new IllegalArgumentException("Usted no cuenta con dinero, no puede realizar esta operación.");

        // process
        String accountType;
        if (amountToWithdraw <= 500) {
            accountType = STANDARD;
        } else if ( amountToWithdraw <= 1000) {
            accountType = PREMIUM;

        } else {
            throw new IllegalArgumentException("Usted excede el limite maximo de retiro");
        }

        // output
        System.out.println("El tipo de cuenta del cliente es: " + accountType);
    }
}

