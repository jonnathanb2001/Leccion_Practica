/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.controller;

import com.tendencias.proyectousuario.model.Administradores;
import com.tendencias.proyectousuario.model.Administradores;
import com.tendencias.proyectousuario.service.AdministradorServiceImpl;
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
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    AdministradorServiceImpl administradorService;

    @Operation(summary = "Se obtiene la lista de Administradores")
    @GetMapping("/listar")
    public ResponseEntity<List<Administradores>> listaAdministradores() {
        return new ResponseEntity<>(administradorService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de la Administradores")
    @PostMapping("/crear")
    public ResponseEntity<Administradores> crearAdministrador(@RequestBody Administradores a) {
        return new ResponseEntity<>(administradorService.save(a), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Administradores> actualizarAdministradores(@PathVariable Integer id, @RequestBody Administradores p) {
        Administradores admin = administradorService.findById(id);
        if (admin != null) {
            try {

                admin.setNombre(p.getNombre());
                admin.setApellido(p.getApellido());
                admin.setCedula(p.getCedula());
                admin.setDireccion(p.getDireccion());
                admin.setTelefono(p.getTelefono());
                admin.setEmail(p.getEmail());
                admin.setClave(p.getClave());

                return new ResponseEntity<>(administradorService.save(admin), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Administradores> eliminarAdministradores(@PathVariable Integer id) {
        administradorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
