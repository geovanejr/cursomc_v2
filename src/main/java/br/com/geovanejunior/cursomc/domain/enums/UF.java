package br.com.geovanejunior.cursomc.domain.enums;

public enum UF {

    MG("Minas Gerais"),
    SP("São Paulo");

    private String nome;

    private UF(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
