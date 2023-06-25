package com.akira.apihemomar.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DataUtil {
    public static  Integer getIndiceData(Date data){
        if(Objects.isNull(data)){throw new RuntimeException("Data inválida");}
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        int indiceDiaDaSemana = calendario.get(Calendar.DAY_OF_WEEK);
       return indiceDiaDaSemana;
    }
}
