package br.com.geovanejunior.cursomc.dto;

import br.com.geovanejunior.cursomc.domain.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.time.Instant;

public class CategoriaDTO {

    private Long id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min=5, max=80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:MM:ss", timezone = "GMT")
    private Instant dataCadastro;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {

        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.dataCadastro = categoria.getDataCadastro();
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

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
