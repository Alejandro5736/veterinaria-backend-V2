package com.duoc.veterinaria.controller;

import com.duoc.veterinaria.model.Factura;
import com.duoc.veterinaria.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas") // Esta ruta debe ser privada en SecurityConfig
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @PostMapping("/generar")
    public Factura crearFactura(@RequestBody Factura factura) {
        return facturaRepository.save(factura);
    }

    @GetMapping("/listar")
    public List<Factura> listarTodas() {
        return facturaRepository.findAll();
    }
}