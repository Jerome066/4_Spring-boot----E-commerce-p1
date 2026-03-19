package com.ecommerce.cliente.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.cliente.DTO.ClienteDTO;
import com.ecommerce.cliente.Model.Cliente;
import com.ecommerce.cliente.Repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    
    public void altaCliente(ClienteDTO clienteDTO) {

        Cliente cliente = Cliente.builder()
                        .nombre(clienteDTO.getNombre())
                        .email(clienteDTO.getEmail())
                        .telefono(clienteDTO.getTelefono())
                        .direccion(clienteDTO.getDireccion())
                        .build();
                        
        clienteRepository.save(cliente);
    }

    public ClienteDTO obtenerCliente(long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setDireccion(cliente.getDireccion());

        return clienteDTO;
    }

    public List<ClienteDTO> obtenerTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream().map(cliente -> {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNombre(cliente.getNombre());
            clienteDTO.setEmail(cliente.getEmail());
            clienteDTO.setTelefono(cliente.getTelefono());
            clienteDTO.setDireccion(cliente.getDireccion());
            return clienteDTO;
        }).toList();
    }

    public void eliminarCliente(long id) {
        clienteRepository.deleteById(id);
    }

    public void actualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        cliente.setNombre(clienteDTO.getNombre());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setDireccion(clienteDTO.getDireccion());

        clienteRepository.save(cliente);
    }
}
