
package business;

import domain.Cliente;
import domain.EntidadeDominio;
import java.util.InputMismatchException;

public class ValidadorCpf implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Cliente){
                    Cliente c = (Cliente)entidade;
                    String cpf = c.getCpf();
                    ValidadorCpf v = new ValidadorCpf();
                    if(v.validaCpf(cpf)==false){
                        return "CPF inválido!";
                    } 
                    return null;
                }
                return "CPF não pode ser validado, pois entidade não é uma pessoa!";
    }
    
    public boolean validaCpf(String CPF) {
        //CPF com 11 dígitos iguais ou != 11 dígitos são inválidos
        String cpf = CPF;
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
            (cpf.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Dígito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-ésimo caractere do CPF em um número:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 é a posicao de '0' na tabela ASCII)
            num = (int)(cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numérico

        // Calculo do 2o. Dígito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }

}


    

