package com.Ecommerce.Compra.Service;

import org.springframework.stereotype.Service;

import com.Ecommerce.Compra.DTO.CompraDTO;
import com.Ecommerce.Compra.DTO.CompraDTO_S;
import com.Ecommerce.Compra.Model.Compra;
import com.Ecommerce.Compra.Repository.CompraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompraService {
    private final CompraRepository CompraRepository;

    public void crearCompra(CompraDTO_S compraDTO_S) {
        

        Compra compra = Compra.builder()
                .idPedido(compraDTO_S.getIdPedido())
                .cantidad(compraDTO_S.getCantidad())
                .precioUnitario(compraDTO_S.getPrecioUnitario())
                .total(compraDTO_S.getTotal())
                .build();

        

        CompraRepository.save(compra);
    }
}
