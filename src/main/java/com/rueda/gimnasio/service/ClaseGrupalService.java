package com.rueda.gimnasio.service;
import com.rueda.gimnasio.model.ClaseGrupal;
import com.rueda.gimnasio.repository.ClaseGrupalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service
public class ClaseGrupalService {
    private final ClaseGrupalRepository repository;
    public ClaseGrupalService(ClaseGrupalRepository repository) { this.repository = repository; }
    public List<ClaseGrupal> listar() { return repository.findAll(); }
    public ClaseGrupal buscar(String nombre) { return repository.findById(nombre).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clase no encontrada")); }
    public ClaseGrupal crear(ClaseGrupal clase) { return repository.save(clase); }
    public ClaseGrupal actualizar(String nombre, ClaseGrupal datos) {
        ClaseGrupal clase = buscar(nombre); clase.setInstructor(datos.getInstructor()); clase.setHorario(datos.getHorario()); clase.setCupos(datos.getCupos()); return repository.save(clase);
    }
    public void eliminar(String nombre) { repository.delete(buscar(nombre)); }
    public ClaseGrupal inscribir(String nombre) { ClaseGrupal clase = buscar(nombre); if (clase.getCupos() <= 0) throw new ResponseStatusException(HttpStatus.CONFLICT, "La clase no tiene cupos"); clase.setCupos(clase.getCupos()-1); return repository.save(clase); }
    public ClaseGrupal cancelarInscripcion(String nombre) { ClaseGrupal clase = buscar(nombre); clase.setCupos(clase.getCupos()+1); return repository.save(clase); }
    public List<ClaseGrupal> conCupos() { return repository.findByCuposGreaterThan(0); }
}
