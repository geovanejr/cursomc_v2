package br.com.geovanejunior.cursomc.dto;

import br.com.geovanejunior.cursomc.domain.Cidade;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CidadeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min=5, max=40, message = "O tamanho deve ser entre 5 e 40 caracteres")
    private String nome;

    public CidadeDTO() {

    }

    public CidadeDTO(Cidade cidade) {
        this.id = cidade.getId();
        this.nome = cidade.getNome();
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
}
