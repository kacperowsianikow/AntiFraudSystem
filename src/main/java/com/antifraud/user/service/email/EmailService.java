package com.antifraud.user.service.email;

import com.antifraud.user.email.IEmailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService implements IEmailSender {
    private final JavaMailSender mailSender;
    @SuppressWarnings("FieldCanBeLocal")
    private final String EMAIL_FROM = "examplemail@company.com";

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm email");
            helper.setFrom(EMAIL_FROM);

            mailSender.send(mimeMessage);
        }
        catch (MessagingException e) {
            log.error("Failed to sen email");
            throw new IllegalStateException("Failed to send email");
        }
    }

}
