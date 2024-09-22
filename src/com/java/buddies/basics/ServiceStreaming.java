package com.java.buddies.basics;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * <b>Caso de uso: <b/> Control de suscripciones a servicios
 * <br>
 * <b>Reglas de negocio: <b/>
 * - Los servicios disponibles y sus precios son:
 *   - Internet: 30.00 USD
 *   - Televisión: 25.00 USD
 *   - Teléfono: 15.00 USD
 * - El usuario puede suscribirse a múltiples servicios.
 * - El costo total es la suma de los costos de los servicios seleccionados.
 * <br>
 * <b>Criterios de aceptación: <b/>
 * - La aplicación debe permitir ingresar los servicios a los que se desea suscribir.
 * - La aplicación debe calcular y mostrar el costo total de la suscripción.
 */

public class ServiceStreaming {
    private static final String INTERNET = "internet";
    private static final String TV = "television";
    private static final String PHONE = "telefono";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, BigDecimal> serviceMap = new HashMap<>();
        serviceMap.put(INTERNET, BigDecimal.valueOf(30.00));
        serviceMap.put(TV, BigDecimal.valueOf(25.00));
        serviceMap.put(PHONE,BigDecimal.valueOf(15.00));

        BigDecimal totalCost = BigDecimal.valueOf(0.00);
        String flag = "SI";

        do {
            mostrarServicios(serviceMap);
            System.out.println("Ingrese el servicio que desea suscribirse : ");
            String service = scanner.next().toLowerCase();

            if(!serviceMap.containsKey(service)){
                throw new IllegalArgumentException("No contamos con ese servicio");
            }

            totalCost = totalCost.add(serviceMap.get(service)) ;

            serviceMap.remove(service);

            if (!serviceMap.isEmpty()){
                System.out.println("Desea adquirir otro servicio? (SI/NO)");
                flag = scanner.next();
            }

        }while (flag.equalsIgnoreCase("SI") && !serviceMap.isEmpty());

        System.out.println("El costo total es de  "+totalCost+ "USD");
    }
    public static void mostrarServicios(Map<String, BigDecimal> serviceMap){
        System.out.println();
        serviceMap.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
