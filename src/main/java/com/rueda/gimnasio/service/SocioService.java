package com.rueda.gimnasio.service;
import com.rueda.gimnasio.model.Socio;
import com.rueda.gimnasio.repository.SocioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service
public class SocioService {
    private final SocioRepository repository;
    public SocioService(SocioRepository repository) { this.repository = repository; }
    public List<Socio> listar() { return repository.findAll(); }
    public Socio buscar(String nombre) { return repository.findById(nombre).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Socio no encontrado")); }
    public Socio crear(Socio socio) { return repository.save(socio); }
    public Socio actualizar(String nombre, Socio datos) {
        Socio socio = buscar(nombre);
        socio.setPlan(datos.getPlan()); socio.setMensualidad(datos.getMensualidad()); socio.setActivo(datos.isActivo());
        return repository.save(socio);
    }
    public void eliminar(String nombre) { repository.delete(buscar(nombre)); }
    public double ingresos() { return repository.findAll().stream().filter(Socio::isActivo).mapToDouble(Socio::getMensualidad).sum(); }
    public Socio desactivar(String nombre) { Socio socio = buscar(nombre); socio.setActivo(false); return repository.save(socio); }
}
