/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.service;

import com.tendencias.proyectousuario.model.Clientes;
import com.tendencias.proyectousuario.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonny
 */
@Service
public class ClienteServiceImpl extends GenericServiceImpl<Clientes, Integer> implements GenericService<Clientes, Integer> {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public CrudRepository<Clientes, Integer> getDao() {
        return clienteRepository;
    }
    
}
