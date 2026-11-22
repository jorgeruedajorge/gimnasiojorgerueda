package com.rueda.gimnasio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Socio {
    @Id
    private String nombre;
    private String plan;
    private double mensualidad;
    private boolean activo;
}
