package com.purchase.order.purchase_order_service.repository;

import com.purchase.order.purchase_order_service.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
