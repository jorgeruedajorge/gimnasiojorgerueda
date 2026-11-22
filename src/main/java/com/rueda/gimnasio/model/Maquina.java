package com.rueda.gimnasio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Maquina {

    @Id
    private String nombre;
    private String marca;
    private int anioCompra;
    private boolean enMantenimiento;
}
