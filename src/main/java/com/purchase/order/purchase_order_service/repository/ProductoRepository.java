package com.purchase.order.purchase_order_service.repository;

import com.purchase.order.purchase_order_service.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private final List<Producto> productos = new ArrayList<>();

    public ProductoRepository() {
        productos.add(new Producto(1L, "Royal Canin Adulto 15kg",     "Alimento seco premium para perros adultos",  45990.0, "ALIMENTO",    50));
        productos.add(new Producto(2L, "Arena Sanitaria para Gatos",  "Arena aglomerante sin polvo 10L",             8990.0, "HIGIENE",     120));
        productos.add(new Producto(3L, "Collar antipulgas Seresto",   "Collar antiparasitario 8 meses de protección",22490.0, "SALUD",       30));
    }

    public List<Producto> findAll() {
        return productos;
    }

    public Optional<Producto> findById(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public List<Producto> findByCategoria(String categoria) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
