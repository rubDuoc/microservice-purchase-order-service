package com.purchase.order.purchase_order_service.controller;

import com.purchase.order.purchase_order_service.model.OrdenCompra;
import com.purchase.order.purchase_order_service.service.OrdenCompraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrdenCompraController.class)
class OrdenCompraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrdenCompraService ordenCompraService;

    private OrdenCompra orden1;
    private OrdenCompra orden2;

    @BeforeEach
    void setUp() {
        orden1 = new OrdenCompra();
        orden1.setId(1L);
        orden1.setClienteId(1L);
        orden1.setProductoId(2L);
        orden1.setCantidad(3);
        orden1.setTotal(59990.0);
        orden1.setEstado("PENDIENTE");
        orden1.setFecha("2025-05-01");

        orden2 = new OrdenCompra();
        orden2.setId(2L);
        orden2.setClienteId(2L);
        orden2.setProductoId(1L);
        orden2.setCantidad(1);
        orden2.setTotal(12990.0);
        orden2.setEstado("ENTREGADO");
        orden2.setFecha("2025-04-20");
    }

    @Test
    @DisplayName("GET /api/ordenes debe retornar lista de órdenes con estado 200")
    void obtenerTodasTest() throws Exception {
        // Arrange
        List<OrdenCompra> ordenes = Arrays.asList(orden1, orden2);
        when(ordenCompraService.obtenerTodas()).thenReturn(ordenes);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ordenes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.ordenCompraList", hasSize(2)))
                .andExpect(jsonPath("$._embedded.ordenCompraList[0].estado", is("PENDIENTE")))
                .andExpect(jsonPath("$._embedded.ordenCompraList[1].estado", is("ENTREGADO")));
    }

    @Test
    @DisplayName("GET /api/ordenes/{id} debe retornar 404 si la orden no existe")
    void obtenerPorIdNoEncontradoTest() throws Exception {
        // Arrange
        when(ordenCompraService.obtenerPorId(99L)).thenReturn(Optional.empty());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ordenes/99"))
                .andExpect(status().isNotFound());
    }
}
