/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.repository;

import com.tendencias.proyectousuario.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jonny
 */
public interface CompraRepository extends JpaRepository<Compra, Integer> {

    @Query(value = "Select * from compra c where c.id_compra = :id_compra", nativeQuery = true)
    public Compra buscarCompra(int id_compra );
    
}
