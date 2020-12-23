package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido pedido);

    void sendEmail(SimpleMailMessage sm);

    void sendOrderConfirmationHTMLEmail(Pedido pedido);

    void sendHTMLEmail(MimeMessage sm);
}
