package com.purchase.order.purchase_order_service.service;

import com.purchase.order.purchase_order_service.model.OrdenCompra;
import com.purchase.order.purchase_order_service.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    public List<OrdenCompra> obtenerTodas() {
        return ordenCompraRepository.findAll();
    }

    public Optional<OrdenCompra> obtenerPorId(Long id) {
        return ordenCompraRepository.findById(id);
    }

    public List<OrdenCompra> obtenerPorEstado(String estado) {
        return ordenCompraRepository.findByEstado(estado);
    }

    public List<OrdenCompra> obtenerPorCliente(Long clienteId) {
        return ordenCompraRepository.findByClienteId(clienteId);
    }
}
