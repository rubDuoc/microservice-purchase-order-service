package com.purchase.order.purchase_order_service.service;

import com.purchase.order.purchase_order_service.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> obtenerTodos();

    Optional<Producto> obtenerPorId(Long id);

    List<Producto> obtenerPorCategoria(String categoria);

    Producto crear(Producto producto);

    Optional<Producto> actualizar(Long id, Producto datos);

    boolean eliminar(Long id);
}
