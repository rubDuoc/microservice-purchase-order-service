package com.purchase.order.purchase_order_service.model;

public class OrdenCompra {

    private Long id;
    private Long clienteId;
    private Long productoId;
    private Integer cantidad;
    private Double total;
    private String estado;
    private String fecha;

    public OrdenCompra() {}

    public OrdenCompra(Long id, Long clienteId, Long productoId, Integer cantidad,
                       Double total, String estado, String fecha) {
        this.id = id;
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
