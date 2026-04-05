package com.duoc.veterinaria.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data // Lombok genera getters y setters
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String clienteNombre;
    private String detalleServicios; // "Consulta + Vacuna"
    private Double montoMedicamentos;
    private Double montoTotal;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion = new Date();
}