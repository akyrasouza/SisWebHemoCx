package com.akira.apihemomar.services.interfaces;

import com.akira.apihemomar.enums.EMAIL;

public interface EnvioEmail {
    public void  envioEmail(String email, EMAIL titulo,String emailBody);
}
