package com.ecommerce.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {


    @EmbeddedId
    private ItemPedidoPK id;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @JsonBackReference
    private Pedido pedido;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @JsonIgnoreProperties("produto")
    private Produto produto;

    @Column
    private Integer quantidade;


    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ItemPedidoPK getId() {

        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void getId(ItemPedidoPK itemPedidoPK) {
    }
}
