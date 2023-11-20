package com.akira.apihemomar.util;

import java.util.Random;

public class GerarCodigo {
    public static String gerarCodigo() {
        Random random = new Random();
        int maximo = 999999;
        int numeroAleatorio = random.nextInt(maximo + 1);
        String codigo = String.format("%06d", numeroAleatorio);
        return codigo;
    }
}
