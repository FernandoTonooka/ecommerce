
package IA;

import java.text.DecimalFormat;
import java.util.Scanner;

public class IA {
    public static void main(String[] args) {
        
        double precoBilhete = 4.40;
        double valorPago=0;
        
        System.out.println("Digite o valor pago:");
        Scanner entrada = new Scanner(System.in);
        String strValorPago = entrada.nextLine();
        
        valorPago = Double.parseDouble(strValorPago);
        
        double valor = precoBilhete - valorPago;
        DecimalFormat decimal = new DecimalFormat("0.00");
        String valorFinal = decimal.format(valor);
        
        if(valorPago==precoBilhete){
            System.out.println("Obrigado! Boa Viagem!");
        }else if(valorPago > precoBilhete){
            System.out.println("Troco de R$ "+ valorFinal);
        }else{
            System.out.println("Faltam R$ "+ valorFinal);
        } 
    }
}
