package com.akira.apihemomar.services;

import com.akira.apihemomar.exception.ConflitoException;
import com.akira.apihemomar.services.interfaces.EnvioEmail;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EnvioEmailUsuario implements EnvioEmail {

    private final  JavaMailSender emailSender;

    public EnvioEmailUsuario(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    @Async
    public void envioEmail(String email,String codigo) {
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(email);
            helper.setSubject("Recuperação de senha Sistema HEMOMAR");
            String emailBody = "<div style='display: flex; align-items: center;'>" +
                    "<div style='padding: 10px;'><strong>Código :</strong></div>"+
                    "<div style='padding: 10px;background-color: #000; color: #fff; font-size: 14px;'><strong>"+" "+ codigo +"</strong>"+"</div>"+"</div>";
            helper.setText(emailBody, true);
            emailSender.send(mimeMessage);
        } catch (MessagingException | MailException e) {
            throw new ConflitoException(e.getMessage());
        }

    }
}
