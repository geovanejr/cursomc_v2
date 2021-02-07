package br.com.geovanejunior.cursomc.config;

import br.com.geovanejunior.cursomc.service.DBService;
import br.com.geovanejunior.cursomc.service.EmailService;
import br.com.geovanejunior.cursomc.service.SMTPEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("prod")
public class ProdConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public Boolean instantiateDatabase() throws ParseException {

        if (!strategy.equals("create")) {

            return false;
        }

        dbService.instantiateTestDatabase();
        return true;
    }

    @Bean
    public EmailService emailService() {

        return new SMTPEmailService();
    }
}
