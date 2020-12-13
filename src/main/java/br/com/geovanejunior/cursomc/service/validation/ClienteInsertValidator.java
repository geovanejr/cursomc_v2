package br.com.geovanejunior.cursomc.service.validation;

import br.com.geovanejunior.cursomc.domain.Cliente;
import br.com.geovanejunior.cursomc.domain.enums.TipoCliente;
import br.com.geovanejunior.cursomc.dto.ClienteNewDTO;
import br.com.geovanejunior.cursomc.repositories.ClienteRepository;
import br.com.geovanejunior.cursomc.resources.exceptions.FieldMessage;
import br.com.geovanejunior.cursomc.service.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDTO clienteNewDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        // inclua os testes aqui, inserindo erros na lista

        if (clienteNewDTO.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getCodTipoCliente()) &&
            !BR.isValidCPF(clienteNewDTO.getCpfOUCNPJ())){

            list.add(new FieldMessage("cpfOUCNPJ", "CPF do Cliente inválido"));
        }

        if (clienteNewDTO.getTipoCliente().equals(TipoCliente.PESSOAJURIDA.getCodTipoCliente()) &&
            !BR.isValidCNPJ(clienteNewDTO.getCpfOUCNPJ())) {

            list.add(new FieldMessage("cpfOUCNPJ", "CNPJ do Cliente inválido"));
        }

        // Validação de existência do email informando em base de dados

        Cliente aux = clienteRepository.findByEmail(clienteNewDTO.getEmail());

        if (aux != null) {
            list.add(new FieldMessage("email", "Email informado (" + clienteNewDTO.getEmail() + ") já existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
