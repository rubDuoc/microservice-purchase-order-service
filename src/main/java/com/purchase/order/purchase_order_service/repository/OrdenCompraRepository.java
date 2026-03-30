package com.purchase.order.purchase_order_service.repository;

import com.purchase.order.purchase_order_service.model.OrdenCompra;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrdenCompraRepository {

    private final List<OrdenCompra> ordenes = new ArrayList<>();

    public OrdenCompraRepository() {
        ordenes.add(new OrdenCompra(1L, 1L, 1L, 2, 91980.0,  "CONFIRMADA", "2026-03-25"));
        ordenes.add(new OrdenCompra(2L, 2L, 3L, 1, 22490.0,  "PENDIENTE",  "2026-03-28"));
        ordenes.add(new OrdenCompra(3L, 3L, 2L, 3, 26970.0,  "ENVIADA",    "2026-03-20"));
    }

    public List<OrdenCompra> findAll() {
        return ordenes;
    }

    public Optional<OrdenCompra> findById(Long id) {
        return ordenes.stream().filter(o -> o.getId().equals(id)).findFirst();
    }

    public List<OrdenCompra> findByEstado(String estado) {
        List<OrdenCompra> resultado = new ArrayList<>();
        for (OrdenCompra o : ordenes) {
            if (o.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(o);
            }
        }
        return resultado;
    }

    public List<OrdenCompra> findByClienteId(Long clienteId) {
        List<OrdenCompra> resultado = new ArrayList<>();
        for (OrdenCompra o : ordenes) {
            if (o.getClienteId().equals(clienteId)) {
                resultado.add(o);
            }
        }
        return resultado;
    }
}
