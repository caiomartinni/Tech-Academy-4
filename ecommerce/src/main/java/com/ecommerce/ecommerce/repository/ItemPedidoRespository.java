package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.ItemPedido;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRespository extends JpaRepository<ItemPedido, Integer> {
}
