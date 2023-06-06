/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.service;

import com.tendencias.proyectousuario.model.Rol;
import com.tendencias.proyectousuario.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonny
 */
@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Integer> implements GenericService<Rol, Integer> {

    @Autowired
    RolRepository rolRepository;

    @Override
    public CrudRepository<Rol, Integer> getDao() {
        return rolRepository;
    }

}
