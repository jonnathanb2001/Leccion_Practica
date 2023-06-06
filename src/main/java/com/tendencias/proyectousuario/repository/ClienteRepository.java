/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.repository;

import com.tendencias.proyectousuario.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jonny
 */
public interface ClienteRepository extends JpaRepository<Clientes, Integer> {

    @Query(value = "Select * from cliente c where c.nombre = :nombre", nativeQuery = true)
    public Clientes buscarCliente(String nombre);
    
}
