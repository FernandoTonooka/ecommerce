
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConvert {
    
    public static Date parseDate(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        return sdf.parse(data);
    }

    public static String parseDate(Date data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        return sdf.format(data);
    }

    public static java.sql.Date getSqlDate(Date data) {
        return new java.sql.Date(data.getTime());
    }   
    
}
