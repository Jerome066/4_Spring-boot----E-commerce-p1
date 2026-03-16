package com.ecommerce.producto.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.producto.Dto.ProductoDTO;
import com.ecommerce.producto.Service.ProductoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    
    @PostMapping("/altaproducto/{ProductoDTO}")
    public String altaProducto (@RequestBody ProductoDTO productoDTO) {
        productoService.altaProducto(productoDTO);
        return "Producto dado de alta correctamente";
    }
    
    @PutMapping("/cambioproducto/{id}")
    public String cambiarProducto (@RequestBody ProductoDTO productoDTO) {
        productoService.modificarProducto(productoDTO);
        return "Producto modificado correctamente";
    }

    @DeleteMapping("/bajaproducto/{id}")
    public String bajaProducto(Long id) {
        productoService.bajaProducto(id);
        return "Producto dado de baja correctamente";
    }

    @GetMapping("/obtenerproducto/{id}")
    public ProductoDTO obtenerProducto(@RequestParam Long id) {
        return productoService.obtenerProductoPorId(id);
    }
    
    @GetMapping("obtenerlistaproductos")
    public List<ProductoDTO> obtenerListaProductos() {
        return productoService.obtenerListaProductos();
    }
    
}
