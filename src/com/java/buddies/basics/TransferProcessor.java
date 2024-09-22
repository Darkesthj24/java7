package com.java.buddies.basics;

import java.util.Scanner;

/**
 * <b>Caso de uso: <b/> Transferencia entre cuentas
 * <br>
 * <b>Reglas de negocio: <b/>
 * - Una de las características de una cuenta bancaria es que tiene saldo.
 * - Durante una transferencia intervienen dos cuentas, la cuenta de origen y la cuenta de destino.
 * - Durante una transferencia, la cuenta origen debe tener saldo disponible para poder realizar la transacción.
 * - Si el monto a transferir supera el saldo disponible en la cuenta origen, entonces la transferencia no puede realizarse.
 * - El monto a transferir debe ser un valor positivo.
 * <br>
 * <b>Criterios de aceptación: <b/> La aplicación debe permitir hacer una transferencia entre cuentas y mostrar sus saldos finales.
 */
public class TransferProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //inputs & validations
        double originAccountBalance = 2000;
        double destinationAccountBalance = 3000;

        System.out.print("Por favor, ingrese el monto a transferir: ");
        double amountToTransfer = scanner.nextDouble();

        if(amountToTransfer <= 0)
            throw new IllegalArgumentException("El monto a transferir debe ser positivo.");

        //process
        if (amountToTransfer <= originAccountBalance) {
            originAccountBalance = originAccountBalance - amountToTransfer;
            destinationAccountBalance = destinationAccountBalance + amountToTransfer;
        } else {
            throw new IllegalArgumentException("La cuenta de origen no tiene saldo suficiente para realizar la operación.");
        }

        //output
        System.out.println("Saldo final en la cuenta origen: " + originAccountBalance);
        System.out.println("Saldo final en la cuenta destino: " + destinationAccountBalance);
    }
}
