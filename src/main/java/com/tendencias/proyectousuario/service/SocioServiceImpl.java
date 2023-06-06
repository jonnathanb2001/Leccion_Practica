/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.service;

import com.tendencias.proyectousuario.model.Administradores;
import com.tendencias.proyectousuario.model.Socios;
import com.tendencias.proyectousuario.repository.AdministradorRepository;
import com.tendencias.proyectousuario.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonny
 */
@Service
public class SocioServiceImpl extends GenericServiceImpl<Socios, Integer> implements GenericService<Socios, Integer> {

    @Autowired
    SocioRepository socioRepository;

    @Override
    public CrudRepository<Socios, Integer> getDao() {
        return socioRepository;
    }
    
}
