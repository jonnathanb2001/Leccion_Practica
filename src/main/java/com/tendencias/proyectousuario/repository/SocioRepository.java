/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.repository;

import com.tendencias.proyectousuario.model.Socios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jonny
 */
public interface SocioRepository extends JpaRepository<Socios, Integer> {

    @Query(value = "Select * from socio s where s.nombre = :nombre", nativeQuery = true)
    public Socios buscarSocio(String nombre);
    
}
