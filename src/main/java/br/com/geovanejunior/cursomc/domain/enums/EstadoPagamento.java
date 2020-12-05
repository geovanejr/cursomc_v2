package br.com.geovanejunior.cursomc.domain.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int codTipoEstadoPagamento;
    private String descrTipoEstadoPagamento;

    private EstadoPagamento(int codTipoEstadoPagamento, String descrTipoEstadoPagamento) {

        this.codTipoEstadoPagamento = codTipoEstadoPagamento;
        this.descrTipoEstadoPagamento = descrTipoEstadoPagamento;
    }

    public int getCodTipoEstadoPagamento() {
        return codTipoEstadoPagamento;
    }

    public void setCodTipoEstadoPagamento(int codTipoEstadoPagamento) {
        this.codTipoEstadoPagamento = codTipoEstadoPagamento;
    }

    public String getDescrTipoEstadoPagamento() {
        return descrTipoEstadoPagamento;
    }

    public void setDescrTipoEstadoPagamento(String descrTipoEstadoPagamento) {
        this.descrTipoEstadoPagamento = descrTipoEstadoPagamento;
    }

    public static EstadoPagamento toEnum(Integer codTipoEstadoPagamento) {

        if (codTipoEstadoPagamento == null) {

            return null;
        }

        for (EstadoPagamento estadoPagamento : EstadoPagamento.values()) {
            if (codTipoEstadoPagamento.equals(estadoPagamento.getCodTipoEstadoPagamento())) {

                return estadoPagamento;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codTipoEstadoPagamento);

    }
    
}
