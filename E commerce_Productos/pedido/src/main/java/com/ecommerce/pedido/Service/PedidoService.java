package com.ecommerce.pedido.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.pedido.DTO.PedidoDTO;
import com.ecommerce.pedido.Model.Pedido;
import com.ecommerce.pedido.Repository.PedidoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public void nuevoPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = Pedido.builder()
                .fechapedido(pedidoDTO.getFechapedido())
                .estado(pedidoDTO.getEstado())
                .idCliente(pedidoDTO.getIdCliente())
                .build();
        pedidoRepository.save(pedido);
    }

    public PedidoDTO obtenerPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        PedidoDTO pedidoDTO = PedidoDTO.builder()
                .fechapedido(pedido.getFechapedido())
                .estado(pedido.getEstado())
                .build();
        return pedidoDTO;
    }
    public List<Pedido> obtenerTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public void actualizarPedido(Long id, PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setFechapedido(pedidoDTO.getFechapedido());
        pedido.setEstado(pedidoDTO.getEstado());
        pedidoRepository.save(pedido);
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
