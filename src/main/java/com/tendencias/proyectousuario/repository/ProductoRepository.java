/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.repository;

import com.tendencias.proyectousuario.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jonny
 */
public interface ProductoRepository extends JpaRepository<Productos, Integer> {

    @Query(value = "Select * from producto p where p.nombre = :nombre", nativeQuery = true)
    public Productos buscarProducto(String nombre);
    
}
