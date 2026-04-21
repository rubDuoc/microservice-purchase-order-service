package com.purchase.order.purchase_order_service.service;

import com.purchase.order.purchase_order_service.model.OrdenCompra;

import java.util.List;
import java.util.Optional;

public interface OrdenCompraService {

    List<OrdenCompra> obtenerTodas();

    Optional<OrdenCompra> obtenerPorId(Long id);

    List<OrdenCompra> obtenerPorEstado(String estado);

    List<OrdenCompra> obtenerPorCliente(Long clienteId);

    OrdenCompra crear(OrdenCompra orden);

    Optional<OrdenCompra> actualizar(Long id, OrdenCompra datos);

    Optional<OrdenCompra> actualizarEstado(Long id, String estado);

    boolean eliminar(Long id);
}
