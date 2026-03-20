package com.Ecommerce.Compra.DTO;

import java.util.List;

import lombok.Data;

@Data
public class CompraDTO {
    private Long idPedido;
    private List<String> Productos;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
}
