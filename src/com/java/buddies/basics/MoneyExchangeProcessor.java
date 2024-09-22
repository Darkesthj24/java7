package com.java.buddies.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <b>Caso de uso: <b/> Tipo de cambio
 * <br>
 * <b>Reglas de negocio: <b/>
 * - El tipo de cambio mide el valor de una moneda en relación a otra.
 * - El monto a convertir debe ser un valor positivo.
 * - Las monedas hábilitadas para el tipo de cambio son soles y dólares.
 * - La tasa de tipo de cambio es 3.78
 * <br>
 * <b>Criterios de aceptación: <b/>
 * - La aplicación debe permitir ingresar la moneda de origen.
 * - La aplicación debe permitir ingresar la moneda de destino.
 * - La aplicación debe permitir ingresar el monto que se desea procesar.
 * - La aplicación debe realizar la conversión de la moneda.
 */
public class MoneyExchangeProcessor {

    private static final String PEN = "PEN";
    private static final String USD = "USD";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //inputs & validations
        Map<String, String> currenciesMap = new HashMap<>();
        currenciesMap.put(PEN, "S/");
        currenciesMap.put(USD, "$");

        double exchangeRate = 3.78;

        System.out.print("Por favor, ingrese la moneda de origen (PEN | USD): ");
        String originCurrency = scanner.next();

        if(!currenciesMap.containsKey(originCurrency))
            throw new IllegalArgumentException("La moneda de origen es inválida.");

        System.out.print("Por favor, ingrese la moneda de destino (PEN | USD): ");
        String destinationCurrency = scanner.next();

        if(!currenciesMap.containsKey(destinationCurrency))
            throw new IllegalArgumentException("La moneda de destino es inválida.");

        System.out.print("Por favor, ingrese el monto que desea convertir: ");
        double amount = scanner.nextDouble();

        if(amount <= 0)
            throw new IllegalArgumentException("El monto a transferir es inválido.");

        //process
        if(PEN.equals(originCurrency) && USD.equals(destinationCurrency))
            amount = amount / exchangeRate;

        if(USD.equals(originCurrency) && PEN.equals(destinationCurrency))
            amount = amount * exchangeRate;

        //output
         System.out.println("El monto convertido es: " + currenciesMap.get(destinationCurrency) + amount);
        }
}
