package com.purchase.order.purchase_order_service.controller;

import com.purchase.order.purchase_order_service.model.OrdenCompra;
import com.purchase.order.purchase_order_service.service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public ResponseEntity<List<OrdenCompra>> obtenerTodas() {
        return ResponseEntity.ok(ordenCompraService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompra> obtenerPorId(@PathVariable Long id) {
        return ordenCompraService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<OrdenCompra>> obtenerPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(ordenCompraService.obtenerPorEstado(estado));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<OrdenCompra>> obtenerPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(ordenCompraService.obtenerPorCliente(clienteId));
    }
}
