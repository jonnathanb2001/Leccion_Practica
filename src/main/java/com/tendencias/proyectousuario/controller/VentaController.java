/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.controller;

import com.tendencias.proyectousuario.model.Ventas;
import com.tendencias.proyectousuario.service.ProductoServiceImpl;
import com.tendencias.proyectousuario.service.VentaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonny
 */
@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    VentaServiceImpl ventaService;

    @Operation(summary = "Se obtiene la lista de Ventas")
    @GetMapping("/listar")
    public ResponseEntity<List<Ventas>> listaVentas() {
        return new ResponseEntity<>(ventaService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de la Ventas")
    @PostMapping("/crear")
    public ResponseEntity<Ventas> crearVentas(@RequestBody Ventas c) {
        return new ResponseEntity<>(ventaService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ventas> actualizarVentas(@PathVariable Integer id, @RequestBody Ventas p) {
        Ventas ve = ventaService.findById(id);
        if (ve != null) {
            try {

                ve.setCantidad(ve.getCantidad());
                ve.setPrecio(ve.getPrecio());
                ve.setFecha(ve.getFecha());

                return new ResponseEntity<>(ventaService.save(ve), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Ventas> eliminarVentas(@PathVariable Integer id) {
        ventaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
