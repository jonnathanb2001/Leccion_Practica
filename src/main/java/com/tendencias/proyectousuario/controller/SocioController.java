/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.controller;

import com.tendencias.proyectousuario.service.SocioServiceImpl;
import com.tendencias.proyectousuario.model.Socios;
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
@RequestMapping("/socio")
public class SocioController {

    @Autowired
    SocioServiceImpl socioService;

    @Operation(summary = "Se obtiene la lista de Socios")
    @GetMapping("/listar")
    public ResponseEntity<List<Socios>> listaSocios() {
        return new ResponseEntity<>(socioService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de la Socios")
    @PostMapping("/crear")
    public ResponseEntity<Socios> crearSocios(@RequestBody Socios p) {
        return new ResponseEntity<>(socioService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Socios> actualizarSocios(@PathVariable Integer id, @RequestBody Socios p) {
        Socios so = socioService.findById(id);
        if (so != null) {
            try {

                so.setNombre(p.getNombre());
                so.setApellido(p.getApellido());
                so.setCedula(p.getCedula());
                so.setDireccion(p.getDireccion());
                so.setTelefono(p.getTelefono());
                so.setEmail(p.getEmail());
                so.setClave(p.getClave());

                return new ResponseEntity<>(socioService.save(so), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Socios> eliminarSocios(@PathVariable Integer id) {
        socioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
