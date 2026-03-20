package com.Ecommerce.Compra.DTO;

import java.util.List;

import lombok.Data;

@Data
public class CompraDTO_S {
    private Long idPedido;
    private List<Long> idProducto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
}
