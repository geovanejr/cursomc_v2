package br.com.geovanejunior.cursomc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public class MockEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
    @Override
    public void sendEmail(SimpleMailMessage msg) {

        LOG.info("\nSimulando envio de email");
        LOG.info(msg.toString());
        LOG.info("\nEmail enviado");
    }

    @Override
    public void sendHTMLEmail(MimeMessage mm) {

        LOG.info("\nSimulando envio de email HTML");
        LOG.info(mm.toString());
        LOG.info("\nEmail enviado");
    }
}
