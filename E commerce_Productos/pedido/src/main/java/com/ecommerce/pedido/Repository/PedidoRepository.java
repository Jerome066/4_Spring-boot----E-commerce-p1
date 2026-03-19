package com.ecommerce.pedido.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.pedido.Model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    
}