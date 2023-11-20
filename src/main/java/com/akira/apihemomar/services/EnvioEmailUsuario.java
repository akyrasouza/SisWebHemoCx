package com.akira.apihemomar.services;

import com.akira.apihemomar.enums.EMAIL;
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
    public void envioEmail(String email, EMAIL titulo,String emailBody) {
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(email);
            helper.setSubject(titulo.getValue());
            helper.setText(emailBody, true);
            emailSender.send(mimeMessage);
        } catch (MessagingException | MailException e) {
            throw new ConflitoException(e.getMessage());
        }

    }
}
