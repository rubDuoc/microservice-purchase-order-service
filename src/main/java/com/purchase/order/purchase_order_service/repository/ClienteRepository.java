package com.purchase.order.purchase_order_service.repository;

import com.purchase.order.purchase_order_service.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

    public ClienteRepository() {
        clientes.add(new Cliente(1L, "María González", "maria.gonzalez@email.com", "+56912345678", "Av. Libertad 456, Santiago"));
        clientes.add(new Cliente(2L, "Carlos Pérez",   "carlos.perez@email.com",   "+56987654321", "Calle Los Pinos 789, Concepción"));
        clientes.add(new Cliente(3L, "Ana Martínez",   "ana.martinez@email.com",   "+56911223344", "Pasaje Las Flores 12, Valparaíso"));
    }

    public List<Cliente> findAll() {
        return clientes;
    }

    public Optional<Cliente> findById(Long id) {
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
}
