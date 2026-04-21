package com.purchase.order.purchase_order_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRODUCTOS")
@Getter
@Setter
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Column(nullable = false, columnDefinition = "NUMBER(10,2)")
    private Double precio;

    @Column(length = 100)
    private String categoria;

    @NotNull(message = "El stock es obligatorio")
    @Column(nullable = false)
    private Integer stock;
}
