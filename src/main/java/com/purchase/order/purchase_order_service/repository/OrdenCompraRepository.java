package com.purchase.order.purchase_order_service.repository;

import com.purchase.order.purchase_order_service.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {

    List<OrdenCompra> findByEstado(String estado);

    List<OrdenCompra> findByClienteId(Long clienteId);
}
