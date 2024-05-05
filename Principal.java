import java.util.Map;
import java.util.Scanner;

public class Principal {
    private static double convertirUSDaARS(double cantidad, double tasa) {
        return cantidad * tasa;
    }
    private static double convertirARSaUSD(double cantidad, double tasa) {
        return cantidad / tasa;
    }
    private static double convertirUSDaMoneda(double cantidad, double tasa) {
        return cantidad * tasa;
    }
    private static double convertirMonedaAUSD(double cantidad, double tasa) {
        return cantidad / tasa;
    }
    public static void main(String[] args) {

        ConsultaDivisa consulta = new ConsultaDivisa();
        Divisa divisa = consulta.buscaDivisa();

        Map<String, Double> conversionRates = divisa.conversionRates();
        double ars = conversionRates.get("ARS");
        double bob = conversionRates.get("BOB");
        double brl = conversionRates.get("BRL");
        double clp = conversionRates.get("CLP");
        double cop = conversionRates.get("COP");
        double usd = conversionRates.get("USD");
        int opcion = 0;
        double importeDelUsuario;

        String menu = """
                *******************************************
                Te damos la bienvenida al Conversor de Monedas
                1)  Dólar               => Peso argentino
                2)  Peso argentino      => Dólar
                3)  Dólar               => Boliviano boliviano
                4)  Boliviano boliviano => Dólar
                5)  Dólar               => Real brasileño
                6)  Real brasileño      => Dólar
                7)  Dólar               => Peso chileno
                8)  Peso chileno        => Dólar
                9)  Dólar               => Peso colombiano
                10) Peso colombiano    => Dólar
                11) Salir
                *******************************************
                A continuación escribe la opción que deseas realizar:""";

        Scanner lectura = new Scanner(System.in);
        while (opcion != 11) {
            System.out.println(menu);
            if (lectura.hasNextInt()) {
                opcion = lectura.nextInt();
                if (opcion >= 1 && opcion <= 10) {
                    System.out.println("Escribe la cantidad que deseas consultar:");
                    if (lectura.hasNextDouble()) {
                        importeDelUsuario = lectura.nextDouble();
                        switch (opcion) {
                            case 1:
                                double usdArs = convertirUSDaARS(importeDelUsuario, ars);
                                System.out.printf("%.4f [USD] equivale a %.4f [ARS]\n", importeDelUsuario, usdArs);
                                break;
                            case 2:
                                double arsUsd = convertirARSaUSD(importeDelUsuario, ars);
                                System.out.printf("%.4f [ARS] equivale a %.4f [USD]\n", importeDelUsuario, arsUsd);
                                break;
                            case 3:
                                double usdBob = convertirUSDaMoneda(importeDelUsuario, bob);
                                System.out.printf("%.4f [USD] equivale a %.4f [BOB]\n", importeDelUsuario, usdBob);
                                break;
                            case 4:
                                double bobUsd = convertirMonedaAUSD(importeDelUsuario, bob);
                                System.out.printf("%.4f [BOB] equivale a %.4f [USD]\n", importeDelUsuario, bobUsd);
                                break;
                            case 5:
                                double usdBrl = convertirUSDaMoneda(importeDelUsuario, brl);
                                System.out.printf("%.4f [USD] equivale a %.4f [BRL]\n", importeDelUsuario, usdBrl);
                                break;
                            case 6:
                                double brlUsd = convertirMonedaAUSD(importeDelUsuario, brl);
                                System.out.printf("%.4f [BRL] equivale a %.4f [USD]\n", importeDelUsuario, brlUsd);
                                break;
                            case 7:
                                double usdClp = convertirUSDaMoneda(importeDelUsuario, clp);
                                System.out.printf("%.4f [USD] equivale a %.4f [CLP]\n", importeDelUsuario, usdClp);
                                break;
                            case 8:
                                double clpUsd = convertirMonedaAUSD(importeDelUsuario, clp);
                                System.out.printf("%.4f [CLP] equivale a %.4f [USD]\n", importeDelUsuario, clpUsd);
                                break;
                            case 9:
                                double usdCop = convertirUSDaMoneda(importeDelUsuario, cop);
                                System.out.printf("%.4f [USD] equivale a %.4f [COP]\n", importeDelUsuario, usdCop);
                                break;
                            case 10:
                                double copUsd = convertirMonedaAUSD(importeDelUsuario, cop);
                                System.out.printf("%.4f [COP] equivale a %.4f [USD]\n", importeDelUsuario, copUsd);
                                break;
                        }
                    } else {
                        System.out.println("¡La cantidad debe ser numérica!");
                        lectura.next();
                    }
                } else if (opcion != 11) {
                    System.out.println("No seleccionaste una opción correcta, por favor utiliza alguna opción del menú");
                    lectura.next();
                }
            } else {
                System.out.println("No seleccionaste una opción correcta, por favor utiliza alguna opción del menú");
                lectura.next();
            }
        }
        System.out.println("Gracias por utilizar el servicio");
    }
}
