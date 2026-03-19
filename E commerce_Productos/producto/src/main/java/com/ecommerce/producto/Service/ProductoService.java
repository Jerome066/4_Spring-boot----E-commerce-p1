package com.ecommerce.producto.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.producto.Dto.ProductoDTO;
import com.ecommerce.producto.Model.Producto;
import com.ecommerce.producto.Repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;

    public void altaProducto(ProductoDTO producto) {

        Producto productoModel = new Producto();
        productoModel.setNombre(producto.getNombre());
        productoModel.setDescripcion(producto.getDescripcion());
        productoModel.setPrecio(producto.getPrecio());
        productoModel.setStock(producto.getStock());

        productoRepository.save(productoModel);

    }
    public void bajaProducto(Long id) {
        productoRepository.deleteById(id);
    }
    public void modificarProducto(ProductoDTO producto) {

        Producto productoModel = new Producto();
        productoModel.setNombre(producto.getNombre());
        productoModel.setDescripcion(producto.getDescripcion());
        productoModel.setPrecio(producto.getPrecio());
        productoModel.setStock(producto.getStock());

        productoRepository.save(productoModel);
    }

    public ProductoDTO obtenerProductoPorId(Long id) {

        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setStock(producto.getStock());

        return productoDTO;
    }

    public List<ProductoDTO> obtenerListaProductos(){
        List<Producto> productos = productoRepository.findAll();
        List<ProductoDTO> productoDTOs = productos.stream().map(producto -> {
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setDescripcion(producto.getDescripcion());
            productoDTO.setPrecio(producto.getPrecio());
            productoDTO.setStock(producto.getStock());
            return productoDTO;
        }).toList();
        return productoDTOs;
        
    }
}
