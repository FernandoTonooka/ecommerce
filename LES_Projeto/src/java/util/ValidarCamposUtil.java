
package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValidarCamposUtil {
    
     //Mapa para simular BD
    public static Map<String, String> alunos = new HashMap<String, String>();
    
    public static boolean validarCamposObrigatorios(ArrayList<Integer> validacoes, StringBuilder msgs,Map<String, String> parametros){
        
        validacoes.add(ValidarCamposUtil.validarCampo(msgs, parametros));  
        
        if(validacoes.contains(0)){
            return false;
        }        
        return true;
    }
    
    public static int validarCampo(StringBuilder msgs, Map<String, String> parametros){
        
        for(String p: parametros.keySet()){
            if(parametros.get(p).trim().equals("")){
                msgs.append(p);
                msgs.append(" é um campo obrigatório!");
                msgs.append("\n");
                return 0;
            }
       }
        return 1;
    }
}

