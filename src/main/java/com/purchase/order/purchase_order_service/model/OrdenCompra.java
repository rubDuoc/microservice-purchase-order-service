package com.purchase.order.purchase_order_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ORDENES_COMPRA")
@Getter
@Setter
@NoArgsConstructor
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID de cliente es obligatorio")
    @Column(name = "CLIENTE_ID", nullable = false)
    private Long clienteId;

    @NotNull(message = "El ID de producto es obligatorio")
    @Column(name = "PRODUCTO_ID", nullable = false)
    private Long productoId;

    @NotNull(message = "La cantidad es obligatoria")
    @Column(nullable = false)
    private Integer cantidad;

    @NotNull(message = "El total es obligatorio")
    @Column(nullable = false, columnDefinition = "NUMBER(12,2)")
    private Double total;

    @NotBlank(message = "El estado es obligatorio")
    @Column(nullable = false, length = 50)
    private String estado;

    @NotBlank(message = "La fecha es obligatoria")
    @Column(nullable = false, length = 20)
    private String fecha;
}
