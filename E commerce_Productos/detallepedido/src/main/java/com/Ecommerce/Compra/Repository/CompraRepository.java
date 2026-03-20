package com.Ecommerce.Compra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.Compra.Model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    
}
