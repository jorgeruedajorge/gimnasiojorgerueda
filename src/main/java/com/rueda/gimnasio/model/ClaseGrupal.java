package com.rueda.gimnasio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ClaseGrupal {

    @Id
    private String nombre;
    private String instructor;
    private String horario;
    private int cupos;
}
