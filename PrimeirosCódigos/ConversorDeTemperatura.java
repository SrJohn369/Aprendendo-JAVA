public class ConversorDeTemperatura {
    public static void main(String[] args) {
        // variáveis
        double temperatura = 24.8;
        int temperaturaConvertida = (int)(temperatura * 1.8) + 32;
        System.out.println(
            String.format(
                "temperatura convertida de Celsius 34.8C para Fahrenheit é : %d", temperaturaConvertida
            )
        );
    }
}
