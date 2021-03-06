package br.com.geovanejunior.cursomc.dto;

import br.com.geovanejunior.cursomc.domain.Cliente;
import br.com.geovanejunior.cursomc.service.validation.ClienteUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteUpdate
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min=5, max=120, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Email(message = "Email inválido")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {

        id = cliente.getId();
        nome = cliente.getNome();
        email = cliente.getEmail();
    }

    public ClienteDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
