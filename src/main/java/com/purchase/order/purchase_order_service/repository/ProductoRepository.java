package com.purchase.order.purchase_order_service.repository;

import com.purchase.order.purchase_order_service.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoria(String categoria);
}
