package com.purchase.order.purchase_order_service.service;

import com.purchase.order.purchase_order_service.model.Producto;
import com.purchase.order.purchase_order_service.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public List<Producto> obtenerPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }
}
