package com.rueda.gimnasio.service;
import com.rueda.gimnasio.model.Maquina;
import com.rueda.gimnasio.repository.MaquinaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.Year;
import java.util.List;
@Service
public class MaquinaService {
    private final MaquinaRepository repository;
    public MaquinaService(MaquinaRepository repository) { this.repository = repository; }
    public List<Maquina> listar() { return repository.findAll(); }
    public Maquina buscar(String nombre) { return repository.findById(nombre).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Máquina no encontrada")); }
    public Maquina crear(Maquina maquina) { return repository.save(maquina); }
    public Maquina actualizar(String nombre, Maquina datos) { Maquina maquina=buscar(nombre); maquina.setMarca(datos.getMarca()); maquina.setAnioCompra(datos.getAnioCompra()); maquina.setEnMantenimiento(datos.isEnMantenimiento()); return repository.save(maquina); }
    public void eliminar(String nombre) { repository.delete(buscar(nombre)); }
    public List<Maquina> operativas() { return repository.findByEnMantenimientoFalse(); }
    public List<Maquina> antiguas(int anios) { return repository.findByAnioCompraLessThan(Year.now().getValue()-anios); }
    public Maquina enviarAMantenimiento(String nombre) { Maquina maquina=buscar(nombre); if (maquina.isEnMantenimiento()) throw new ResponseStatusException(HttpStatus.CONFLICT, "La máquina ya estaba en mantenimiento"); maquina.setEnMantenimiento(true); return repository.save(maquina); }
}
