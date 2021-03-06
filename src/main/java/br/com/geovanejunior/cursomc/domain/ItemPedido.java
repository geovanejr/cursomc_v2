package br.com.geovanejunior.cursomc.domain;

import br.com.geovanejunior.cursomc.domain.utils.FormataDados;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

@Entity
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setPedido(Pedido pedido) {

        id.setPedido(pedido);
    }

    public Produto getProduto() {

        return id.getProduto();
    }

    public void setProduto(Produto produto) {

        id.setProduto(produto);
    }

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getSubTotal() {

        return getQuantidade() * getPreco() - getValorDesconto();
    }

    public Double getValorDesconto() {

        return getPreco() * getDesconto() / 100;
    }

    @Override
    public String toString() {

        FormataDados fmt = new FormataDados();

        StringBuilder sb = new StringBuilder();
        sb.append(getProduto().getNome());
        sb.append(", Qtde: ").append(getQuantidade());
        sb.append(", Preço Unitário: ").append(fmt.formataValor(getPreco()));
        sb.append(", SubTotal: ").append(fmt.formataValor(getSubTotal()));
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
