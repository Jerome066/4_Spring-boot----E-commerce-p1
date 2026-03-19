package com.ecommerce.pedido.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.pedido.DTO.PedidoDTO;
import com.ecommerce.pedido.Service.PedidoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping("/altapedido")
    public void altaPedido(@RequestBody PedidoDTO pedido) {
        pedidoService.nuevoPedido(pedido);
    }

    @GetMapping("/obtenerpedido/{id}")
    public PedidoDTO obtenerPedido(@PathVariable Long id) {
        return pedidoService.obtenerPedido(id);
    }

    @GetMapping("/obtenerpedidos")
    public List<PedidoDTO> obtenerPedidos() {
        return pedidoService.obtenerTodosPedidos().stream()
                .map(pedido -> PedidoDTO.builder()
                        .fechapedido(pedido.getFechapedido())
                        .estado(pedido.getEstado())
                        .build())
                .toList();
    }

    @PutMapping("/actualizarpedido/{id}")
    public void actualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedido) {
        pedidoService.actualizarPedido(id, pedido);
    }

    @DeleteMapping("/eleminarpedido/{id}")
    public void eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
    }

}
