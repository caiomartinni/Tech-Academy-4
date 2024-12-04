package com.ecommerce.ecommerce.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

import javax.swing.*;
import java.util.Objects;

public class ItemPedido_RequestDTO {

    private Integer id_pedido;

    private Integer id_produto;

    private Integer quantidade;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido_RequestDTO that = (ItemPedido_RequestDTO) o;
        return Objects.equals(id_pedido, that.id_pedido) && Objects.equals(id_produto, that.id_produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pedido, id_produto);
    }
}
