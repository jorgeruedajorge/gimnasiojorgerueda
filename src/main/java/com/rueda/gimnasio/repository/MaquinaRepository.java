package com.rueda.gimnasio.repository;

import com.rueda.gimnasio.model.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaquinaRepository extends JpaRepository <Maquina, String> {
    List<Maquina> findByEnMantenimientoFalse();
    List<Maquina> findByAnioCompraLessThan(int anioCompra);
}
