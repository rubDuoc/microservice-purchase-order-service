package com.purchase.order.purchase_order_service.service;

import com.purchase.order.purchase_order_service.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> obtenerTodos();

    Optional<Cliente> obtenerPorId(Long id);

    Cliente crear(Cliente cliente);

    Optional<Cliente> actualizar(Long id, Cliente datos);

    boolean eliminar(Long id);
}
