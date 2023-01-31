package org.generation.ecommercedb.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.generation.ecommercedb.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
