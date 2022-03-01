
package util;

import java.util.Date;
import java.util.Set;

public class Log {
    
    public static void gerarLog(String operacao, Set<String> parametros){
        
        Date date = new Date();
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        int hour = date.getHours();
        
        System.err.print("LOG: "+operacao+"\n");
        
        for(String p: parametros){
            System.out.print(p);
            System.out.print(" - ");
        }
        
        System.out.print("Dia: "+day+" / "+month+" / "+year+" - Hora: "+hour);
        
    }
}
