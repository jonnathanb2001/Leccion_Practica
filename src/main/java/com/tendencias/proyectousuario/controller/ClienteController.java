/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.controller;

import com.tendencias.proyectousuario.model.Clientes;
import com.tendencias.proyectousuario.service.AdministradorServiceImpl;
import com.tendencias.proyectousuario.service.ClienteServiceImpl;
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
@RequestMapping("/cliente")
public class ClienteController {
     @Autowired
    ClienteServiceImpl clienteService;

    @Operation(summary = "Se obtiene la lista de Clientes")
    @GetMapping("/listar")
    public ResponseEntity<List<Clientes>> listaClientes() {
        return new ResponseEntity<>(clienteService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de la Clientes")
    @PostMapping("/crear")
    public ResponseEntity<Clientes> crearClientes(@RequestBody Clientes c) {
        return new ResponseEntity<>(clienteService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Clientes> actualizarClientes(@PathVariable Integer id, @RequestBody Clientes p) {
        Clientes cli = clienteService.findById(id);
        if (cli != null) {
            try {

                cli.setNombre(p.getNombre());
                cli.setApellido(p.getApellido());
                cli.setCedula(p.getCedula());
                cli.setDireccion(p.getDireccion());
                cli.setTelefono(p.getTelefono());
                cli.setEmail(p.getEmail());
                cli.setClave(p.getClave());

                return new ResponseEntity<>(clienteService.save(cli), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Clientes> eliminarClientes(@PathVariable Integer id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
