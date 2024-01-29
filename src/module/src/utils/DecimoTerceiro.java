package module.src.utils;

public class DecimoTerceiro {
    public static void calcularDecimoTerceiro(double salario) {
        double decimoTerceiro = salario / 2;
        System.out.println("A primeira parcela é: " + decimoTerceiro);
        if (salario <= 1500.0) {
            decimoTerceiro -= 1.09;
            System.out.println("Sua segunda parcela é: " + decimoTerceiro);
        } else if (salario <= 2500.0) {
            decimoTerceiro -= 1.16;
            System.out.println("Sua segunda parcela é: " + decimoTerceiro);
        } else if (salario <= 4000.0) {
            decimoTerceiro -= 1.29;
            System.out.println("Sua segunda parcela é: " + decimoTerceiro);
        }
    }
}
