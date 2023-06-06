/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.controller;

import com.tendencias.proyectousuario.model.Productos;
import com.tendencias.proyectousuario.service.ProductoServiceImpl;
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
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServiceImpl productoService;

    @Operation(summary = "Se obtiene la lista de Productos")
    @GetMapping("/listar")
    public ResponseEntity<List<Productos>> listaProductos() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de la Productos")
    @PostMapping("/crear")
    public ResponseEntity<Productos> crearProductos(@RequestBody Productos c) {
        return new ResponseEntity<>(productoService.save(c), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Productos> actualizarProductos(@PathVariable Integer id, @RequestBody Productos p) {
        Productos pro = productoService.findById(id);
        if (pro != null) {
            try {

                pro.setNombre(pro.getNombre());
                pro.setDescripcion(pro.getDescripcion());
                pro.setCategoria(pro.getCategoria());
                pro.setPrecio_emprendedor(pro.getPrecio_emprendedor());
                pro.setImagenes(pro.getImagenes());
                pro.setTalla(pro.getTalla());
                pro.setColor(pro.getColor());

                return new ResponseEntity<>(productoService.save(pro), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Productos> eliminarProductos(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
