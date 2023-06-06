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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author jonny
 */
@Data
@Entity
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @NotBlank(message = "El id_proveedor no puede estar en blanco")
    @Column(name = "id_proveedor")
    private int id_proveedor;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    //@Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Column(name = "descripcion")
    private String descripcion;

    @NotBlank(message = "La categoria no puede estar en blanco")
    @Column(name = "categoria")
    private String categoria;

    @NotBlank(message = "Precio emprendedor no puede estar en blanco")
    @Column(name = "precio_emprendedor")
    private double precio_emprendedor;

    @NotBlank(message = "La imagen no puede estar en blanco")
    @Column(name = "imagenes")
    private String imagenes;

    @NotBlank(message = "La talla no puede estar en blanco")
    @Column(name = "talla")
    private String talla;

    @NotBlank(message = "El color no puede estar en blanco")
    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    private Proveedores proveedor; //esta persona debe estar igual que en la clase usuario

}
