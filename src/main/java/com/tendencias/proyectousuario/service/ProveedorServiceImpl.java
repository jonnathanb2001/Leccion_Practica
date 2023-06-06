/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.service;

import com.tendencias.proyectousuario.model.Administradores;
import com.tendencias.proyectousuario.model.Proveedores;
import com.tendencias.proyectousuario.repository.AdministradorRepository;
import com.tendencias.proyectousuario.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonny
 */
@Service
public class ProveedorServiceImpl extends GenericServiceImpl<Proveedores, Integer> implements GenericService<Proveedores, Integer> {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public CrudRepository<Proveedores, Integer> getDao() {
        return proveedorRepository;
    }
    
}
