package br.com.geovanejunior.cursomc.domain.enums;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDA(2, "Pessoa Jurírica");

    private int codTipoCliente;
    private String descrTipoCliente;

    private TipoCliente(int codTipoCliente, String descrTipoCliente) {

        this.codTipoCliente = codTipoCliente;
        this.descrTipoCliente = descrTipoCliente;
    }

    public int getCodTipoCliente() {

        return codTipoCliente;
    }

    public String getDescrTipoCliente() {
        return descrTipoCliente;
    }

    public static TipoCliente toEnum(Integer codTipoCliente) {

        if (codTipoCliente == null) {

            return null;
        }

        for (TipoCliente tipoCliente : TipoCliente.values()) {
            if (codTipoCliente.equals(tipoCliente.getCodTipoCliente())) {

                return tipoCliente;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codTipoCliente);

    }
}
