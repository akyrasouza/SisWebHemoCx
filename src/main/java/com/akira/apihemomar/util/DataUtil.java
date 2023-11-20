package com.akira.apihemomar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public static Boolean dataPassado(Date  dataComparacao){
        Date dataAtual = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataAtual);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date dataZerado = calendar.getTime();
        if (dataComparacao.before(dataZerado)) {
              return true;
        }
        return false;
    }
    public static String formatarData(Date data){
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoData.format(data);
       return dataFormatada;
    }
}
