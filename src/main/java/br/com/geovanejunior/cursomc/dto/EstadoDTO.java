package br.com.geovanejunior.cursomc.dto;

import br.com.geovanejunior.cursomc.domain.Estado;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class EstadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min=2, max=2, message = "O tamanho deve ser 2 caracteres")
    private String UF;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min=2, max=30, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    public EstadoDTO() {
    }

    public EstadoDTO(Estado estado) {

        this.id = estado.getId();
        this.nome = estado.getNome();
        this.UF = estado.getUF();
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

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
}
