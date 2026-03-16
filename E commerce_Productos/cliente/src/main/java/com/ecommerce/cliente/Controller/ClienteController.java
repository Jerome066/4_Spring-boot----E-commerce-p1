package com.ecommerce.cliente.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.cliente.DTO.ClienteDTO;
import com.ecommerce.cliente.Service.ClienteService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
@RequestMapping("/clientes")

@AllArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping("/altacliente")
    public String altaCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.altaCliente(clienteDTO);
        return "Cliente dado de alta exitosamente";
    }

    @GetMapping("/obtenerCliente/{id}")
    public String obtenerCliente(@PathVariable long id) {
        clienteService.obtenerCliente(id);
        return "Cliente obtenido exitosamente";
    }
    
    @GetMapping("/obtenerClientes")
    public List<ClienteDTO> obtenerClientes () {
        return clienteService.obtenerTodosClientes();
    }
    
    @PutMapping("/actualizarCliente/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        clienteService.actualizarCliente(id, clienteDTO);
        return "Cliente actualizado exitosamente";
    }
}
