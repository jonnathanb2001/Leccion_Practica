/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.service;

import com.tendencias.proyectousuario.model.Administradores;
import com.tendencias.proyectousuario.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonny
 */
@Service
public class AdministradorServiceImpl extends GenericServiceImpl<Administradores, Integer> implements GenericService<Administradores, Integer> {

    @Autowired
    AdministradorRepository administradorRepository;

    @Override
    public CrudRepository<Administradores, Integer> getDao() {
        return administradorRepository;
    }
    
}
