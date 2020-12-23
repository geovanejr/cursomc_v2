package br.com.geovanejunior.cursomc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

public class SMTPEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(SMTPEmailService.class);

    @Autowired
    private MailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(SimpleMailMessage mm) {

        LOG.info("\nEnviando email via dev");

        mailSender.send(mm);

        LOG.info("\nEmail enviado");
    }

    @Override
    public void sendHTMLEmail(MimeMessage mm) {

        LOG.info("\nEnviando email via dev - HTML");

        javaMailSender.send(mm);

        LOG.info("\nEmail enviado");
    }
}
