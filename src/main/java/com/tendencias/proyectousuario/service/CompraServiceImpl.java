/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.service;


import com.tendencias.proyectousuario.model.Compra;
import com.tendencias.proyectousuario.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonny
 */
@Service
public class CompraServiceImpl extends GenericServiceImpl<Compra, Integer> implements GenericService<Compra, Integer> {

    @Autowired
    CompraRepository compraRepository;

    @Override
    public CrudRepository<Compra, Integer> getDao() {
        return compraRepository;
    }
    
}
