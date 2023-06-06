/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.repository;

import com.tendencias.proyectousuario.model.Administradores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jonny
 */
public interface AdministradorRepository extends JpaRepository<Administradores, Integer> {

    @Query(value = "Select * from administrador a where a.nombre = :nombre", nativeQuery = true)
    public Administradores buscarAdministrador(String nombre);
    
}
