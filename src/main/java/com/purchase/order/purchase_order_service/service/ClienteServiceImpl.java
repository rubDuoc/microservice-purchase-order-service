package com.purchase.order.purchase_order_service.service;

import com.purchase.order.purchase_order_service.model.Cliente;
import com.purchase.order.purchase_order_service.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> actualizar(Long id, Cliente datos) {
        return clienteRepository.findById(id).map(c -> {
            c.setNombre(datos.getNombre());
            c.setEmail(datos.getEmail());
            c.setTelefono(datos.getTelefono());
            c.setDireccion(datos.getDireccion());
            return clienteRepository.save(c);
        });
    }

    @Override
    public boolean eliminar(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
