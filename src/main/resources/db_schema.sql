-- ============================================================
-- Script de base de datos: purchase-order-service
-- Base de datos: Oracle Autonomous Database
-- Usuario: BD_DEV
-- ============================================================

-- Tabla CLIENTES (sin dependencias)
CREATE TABLE CLIENTES (
    ID         NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    NOMBRE     VARCHAR2(200) NOT NULL,
    EMAIL      VARCHAR2(200) NOT NULL UNIQUE,
    TELEFONO   VARCHAR2(20),
    DIRECCION  VARCHAR2(300)
);

-- Tabla PRODUCTOS (sin dependencias)
CREATE TABLE PRODUCTOS (
    ID          NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    NOMBRE      VARCHAR2(200)  NOT NULL,
    DESCRIPCION VARCHAR2(500),
    PRECIO      NUMBER(10, 2)  NOT NULL,
    CATEGORIA   VARCHAR2(100),
    STOCK       NUMBER(10)     NOT NULL
);

-- Tabla ORDENES_COMPRA (referencia a CLIENTES y PRODUCTOS)
CREATE TABLE ORDENES_COMPRA (
    ID          NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    CLIENTE_ID  NUMBER        NOT NULL,
    PRODUCTO_ID NUMBER        NOT NULL,
    CANTIDAD    NUMBER(10)    NOT NULL,
    TOTAL       NUMBER(12, 2) NOT NULL,
    ESTADO      VARCHAR2(50)  NOT NULL,
    FECHA       VARCHAR2(20)  NOT NULL,
    CONSTRAINT FK_ORDEN_CLIENTE  FOREIGN KEY (CLIENTE_ID)  REFERENCES CLIENTES(ID),
    CONSTRAINT FK_ORDEN_PRODUCTO FOREIGN KEY (PRODUCTO_ID) REFERENCES PRODUCTOS(ID)
);

-- ============================================================
-- Datos de prueba (mínimo 3 registros por tabla)
-- ============================================================

INSERT INTO CLIENTES (NOMBRE, EMAIL, TELEFONO, DIRECCION)
VALUES ('María González', 'maria.gonzalez@email.com', '+56912345678', 'Av. Libertad 456, Santiago');

INSERT INTO CLIENTES (NOMBRE, EMAIL, TELEFONO, DIRECCION)
VALUES ('Carlos Pérez', 'carlos.perez@email.com', '+56987654321', 'Calle Los Pinos 789, Concepción');

INSERT INTO CLIENTES (NOMBRE, EMAIL, TELEFONO, DIRECCION)
VALUES ('Ana Martínez', 'ana.martinez@email.com', '+56911223344', 'Pasaje Las Flores 12, Valparaíso');

INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO, CATEGORIA, STOCK)
VALUES ('Royal Canin Adulto 15kg', 'Alimento seco premium para perros adultos', 45990.0, 'ALIMENTO', 50);

INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO, CATEGORIA, STOCK)
VALUES ('Arena Sanitaria para Gatos', 'Arena aglomerante sin polvo 10L', 8990.0, 'HIGIENE', 120);

INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO, CATEGORIA, STOCK)
VALUES ('Collar antipulgas Seresto', 'Collar antiparasitario 8 meses de protección', 22490.0, 'SALUD', 30);

INSERT INTO ORDENES_COMPRA (CLIENTE_ID, PRODUCTO_ID, CANTIDAD, TOTAL, ESTADO, FECHA)
VALUES (1, 1, 2, 91980.0, 'CONFIRMADA', '2026-03-25');

INSERT INTO ORDENES_COMPRA (CLIENTE_ID, PRODUCTO_ID, CANTIDAD, TOTAL, ESTADO, FECHA)
VALUES (2, 3, 1, 22490.0, 'PENDIENTE', '2026-03-28');

INSERT INTO ORDENES_COMPRA (CLIENTE_ID, PRODUCTO_ID, CANTIDAD, TOTAL, ESTADO, FECHA)
VALUES (3, 2, 3, 26970.0, 'ENVIADA', '2026-03-20');

COMMIT;
