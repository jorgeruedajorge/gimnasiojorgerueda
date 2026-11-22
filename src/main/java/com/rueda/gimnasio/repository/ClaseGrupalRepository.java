package com.rueda.gimnasio.repository;

import com.rueda.gimnasio.model.ClaseGrupal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClaseGrupalRepository extends JpaRepository <ClaseGrupal, String> {
    List<ClaseGrupal> findByCuposGreaterThan(int cupos);
}
