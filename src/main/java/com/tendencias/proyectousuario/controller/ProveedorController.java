/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.controller;

import com.tendencias.proyectousuario.model.Proveedores;
import com.tendencias.proyectousuario.service.ClienteServiceImpl;
import com.tendencias.proyectousuario.service.ProveedorServiceImpl;
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
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    ProveedorServiceImpl proveedorService;

    @Operation(summary = "Se obtiene la lista de Proveedores")
    @GetMapping("/listar")
    public ResponseEntity<List<Proveedores>> listaProveedores() {
        return new ResponseEntity<>(proveedorService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de la Proveedores")
    @PostMapping("/crear")
    public ResponseEntity<Proveedores> crearProveedores(@RequestBody Proveedores p) {
        return new ResponseEntity<>(proveedorService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proveedores> actualizarProveedores(@PathVariable Integer id, @RequestBody Proveedores p) {
        Proveedores pro = proveedorService.findById(id);
        if (pro != null) {
            try {

                pro.setNombre(p.getNombre());
                pro.setApellido(p.getApellido());
                pro.setCedula(p.getCedula());
                pro.setDireccion(p.getDireccion());
                pro.setTelefono(p.getTelefono());
                pro.setEmail(p.getEmail());
                pro.setClave(p.getClave());

                return new ResponseEntity<>(proveedorService.save(pro), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Proveedores> eliminarProveedores(@PathVariable Integer id) {
        proveedorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
