package com.rueda.gimnasio.repository;
import com.rueda.gimnasio.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SocioRepository extends JpaRepository<Socio, String> { }
