/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author jonny
 */
@Data
@Entity
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private int id_venta;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "id_cliente")
    private int id_cliente;

    //@Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Column(name = "id_producto")
    private int id_producto;

    @NotBlank(message = "La categoria no puede estar en blanco")
    @Column(name = "cantidad")
    private double cantidad;

    @NotBlank(message = "Precio emprendedor no puede estar en blanco")
    @Column(name = "precio")
    private double precio;

    @NotBlank(message = "La imagen no puede estar en blanco")
    @Column(name = "fecha")
    private String fecha;

}
