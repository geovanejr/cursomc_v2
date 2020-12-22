package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido pedido);

    void sendEmail(SimpleMailMessage sm);
}
