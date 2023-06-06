/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.controller;

import com.tendencias.proyectousuario.model.Compra;
import com.tendencias.proyectousuario.service.ClienteServiceImpl;
import com.tendencias.proyectousuario.service.CompraServiceImpl;
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
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    CompraServiceImpl compraService;

    @Operation(summary = "Se obtiene la lista de Compra")
    @GetMapping("/listar")
    public ResponseEntity<List<Compra>> listaCompra() {
        return new ResponseEntity<>(compraService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de la Compra")
    @PostMapping("/crear")
    public ResponseEntity<Compra> crearCompra(@RequestBody Compra c) {
        return new ResponseEntity<>(compraService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Compra> actualizarCompra(@PathVariable Integer id, @RequestBody Compra p) {
        Compra co = compraService.findById(id);
        if (co != null) {
            try {

                co.setId_proveedor(co.getId_proveedor());
                co.setPvp_producto(co.getPvp_producto());
                return new ResponseEntity<>(compraService.save(co), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Compra> eliminarCompra(@PathVariable Integer id) {
        compraService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
