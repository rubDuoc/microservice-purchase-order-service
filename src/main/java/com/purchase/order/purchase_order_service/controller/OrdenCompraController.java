package com.purchase.order.purchase_order_service.controller;

import com.purchase.order.purchase_order_service.model.OrdenCompra;
import com.purchase.order.purchase_order_service.service.OrdenCompraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

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

    @PostMapping
    public ResponseEntity<OrdenCompra> crear(@Valid @RequestBody OrdenCompra orden) {
        return ResponseEntity.ok(ordenCompraService.crear(orden));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenCompra> actualizar(@PathVariable Long id, @Valid @RequestBody OrdenCompra datos) {
        return ordenCompraService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<OrdenCompra> actualizarEstado(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String estado = body.get("estado");
        return ordenCompraService.actualizarEstado(id, estado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (ordenCompraService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
