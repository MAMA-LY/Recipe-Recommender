package com.brainfood.security;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("mamaly.brainfood@gmail.com");
            helper.setTo(toEmail);
            helper.setText(body);
            helper.setSubject(subject);
            javaMailSender.send(message);
            System.out.println("Email Sent ");
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
