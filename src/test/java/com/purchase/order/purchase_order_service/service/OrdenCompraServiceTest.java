package com.purchase.order.purchase_order_service.service;

import com.purchase.order.purchase_order_service.model.OrdenCompra;
import com.purchase.order.purchase_order_service.repository.OrdenCompraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrdenCompraServiceTest {

    @Mock
    private OrdenCompraRepository ordenCompraRepository;

    @InjectMocks
    private OrdenCompraServiceImpl ordenCompraService;

    private OrdenCompra orden;

    @BeforeEach
    void setUp() {
        orden = new OrdenCompra();
        orden.setClienteId(1L);
        orden.setProductoId(2L);
        orden.setCantidad(3);
        orden.setTotal(59990.0);
        orden.setEstado("PENDIENTE");
        orden.setFecha("2025-05-01");
    }

    @Test
    @DisplayName("Debe crear una orden de compra y retornarla correctamente")
    void crearOrdenCompraTest() {
        // Arrange
        when(ordenCompraRepository.save(orden)).thenReturn(orden);

        // Act
        OrdenCompra resultado = ordenCompraService.crear(orden);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getClienteId());
        assertEquals("PENDIENTE", resultado.getEstado());
        assertEquals(59990.0, resultado.getTotal());
        verify(ordenCompraRepository, times(1)).save(orden);
    }

    @Test
    @DisplayName("Debe obtener todas las órdenes de compra correctamente")
    void obtenerTodasTest() {
        // Arrange
        OrdenCompra orden2 = new OrdenCompra();
        orden2.setClienteId(2L);
        orden2.setProductoId(3L);
        orden2.setCantidad(1);
        orden2.setTotal(12990.0);
        orden2.setEstado("ENTREGADO");
        orden2.setFecha("2025-04-20");

        when(ordenCompraRepository.findAll()).thenReturn(Arrays.asList(orden, orden2));

        // Act
        List<OrdenCompra> resultado = ordenCompraService.obtenerTodas();

        // Assert
        assertEquals(2, resultado.size());
        assertEquals("PENDIENTE", resultado.get(0).getEstado());
        assertEquals("ENTREGADO", resultado.get(1).getEstado());
        verify(ordenCompraRepository, times(1)).findAll();
    }
}
