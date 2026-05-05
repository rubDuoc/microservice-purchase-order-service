package com.purchase.order.purchase_order_service.controller;

import com.purchase.order.purchase_order_service.model.OrdenCompra;
import com.purchase.order.purchase_order_service.service.OrdenCompraService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @GetMapping
    public CollectionModel<EntityModel<OrdenCompra>> obtenerTodas() {
        List<EntityModel<OrdenCompra>> ordenes = ordenCompraService.obtenerTodas().stream()
                .map(o -> EntityModel.of(o,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerPorId(o.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerTodas()).withRel("all-ordenes")))
                .collect(Collectors.toList());

        return CollectionModel.of(ordenes,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerTodas()).withSelfRel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<OrdenCompra>> obtenerPorId(@PathVariable Long id) {
        return ordenCompraService.obtenerPorId(id)
                .map(o -> EntityModel.of(o,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerPorId(id)).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerTodas()).withRel("all-ordenes")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public CollectionModel<EntityModel<OrdenCompra>> obtenerPorEstado(@PathVariable String estado) {
        List<EntityModel<OrdenCompra>> ordenes = ordenCompraService.obtenerPorEstado(estado).stream()
                .map(o -> EntityModel.of(o,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerPorId(o.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerTodas()).withRel("all-ordenes")))
                .collect(Collectors.toList());

        return CollectionModel.of(ordenes,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerTodas()).withRel("all-ordenes"));
    }

    @GetMapping("/cliente/{clienteId}")
    public CollectionModel<EntityModel<OrdenCompra>> obtenerPorCliente(@PathVariable Long clienteId) {
        List<EntityModel<OrdenCompra>> ordenes = ordenCompraService.obtenerPorCliente(clienteId).stream()
                .map(o -> EntityModel.of(o,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerPorId(o.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerTodas()).withRel("all-ordenes")))
                .collect(Collectors.toList());

        return CollectionModel.of(ordenes,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerTodas()).withRel("all-ordenes"));
    }

    @PostMapping
    public ResponseEntity<EntityModel<OrdenCompra>> crear(@Valid @RequestBody OrdenCompra orden) {
        OrdenCompra creada = ordenCompraService.crear(orden);
        EntityModel<OrdenCompra> model = EntityModel.of(creada,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerPorId(creada.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerTodas()).withRel("all-ordenes"));
        return ResponseEntity.ok(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<OrdenCompra>> actualizar(@PathVariable Long id, @Valid @RequestBody OrdenCompra datos) {
        return ordenCompraService.actualizar(id, datos)
                .map(o -> EntityModel.of(o,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerPorId(id)).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerTodas()).withRel("all-ordenes")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<EntityModel<OrdenCompra>> actualizarEstado(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String estado = body.get("estado");
        return ordenCompraService.actualizarEstado(id, estado)
                .map(o -> EntityModel.of(o,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerPorId(id)).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrdenCompraController.class).obtenerTodas()).withRel("all-ordenes")))
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
