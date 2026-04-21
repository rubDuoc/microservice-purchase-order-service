package com.purchase.order.purchase_order_service.service;

import com.purchase.order.purchase_order_service.model.OrdenCompra;
import com.purchase.order.purchase_order_service.repository.OrdenCompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;

    public OrdenCompraServiceImpl(OrdenCompraRepository ordenCompraRepository) {
        this.ordenCompraRepository = ordenCompraRepository;
    }

    @Override
    public List<OrdenCompra> obtenerTodas() {
        return ordenCompraRepository.findAll();
    }

    @Override
    public Optional<OrdenCompra> obtenerPorId(Long id) {
        return ordenCompraRepository.findById(id);
    }

    @Override
    public List<OrdenCompra> obtenerPorEstado(String estado) {
        return ordenCompraRepository.findByEstado(estado);
    }

    @Override
    public List<OrdenCompra> obtenerPorCliente(Long clienteId) {
        return ordenCompraRepository.findByClienteId(clienteId);
    }

    @Override
    public OrdenCompra crear(OrdenCompra orden) {
        return ordenCompraRepository.save(orden);
    }

    @Override
    public Optional<OrdenCompra> actualizar(Long id, OrdenCompra datos) {
        return ordenCompraRepository.findById(id).map(o -> {
            o.setClienteId(datos.getClienteId());
            o.setProductoId(datos.getProductoId());
            o.setCantidad(datos.getCantidad());
            o.setTotal(datos.getTotal());
            o.setEstado(datos.getEstado());
            o.setFecha(datos.getFecha());
            return ordenCompraRepository.save(o);
        });
    }

    @Override
    public Optional<OrdenCompra> actualizarEstado(Long id, String estado) {
        return ordenCompraRepository.findById(id).map(o -> {
            o.setEstado(estado);
            return ordenCompraRepository.save(o);
        });
    }

    @Override
    public boolean eliminar(Long id) {
        if (ordenCompraRepository.existsById(id)) {
            ordenCompraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
