package com.rueda.gimnasio.controller;
import com.rueda.gimnasio.model.ClaseGrupal;
import com.rueda.gimnasio.service.ClaseGrupalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/clase")
public class ClaseGrupalController {
    private final ClaseGrupalService service;
    public ClaseGrupalController(ClaseGrupalService service) { this.service = service; }
    @GetMapping public List<ClaseGrupal> listar() { return service.listar(); }
    @GetMapping("/{id}") public ClaseGrupal buscar(@PathVariable("id") String nombre) { return service.buscar(nombre); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public ClaseGrupal crear(@RequestBody ClaseGrupal clase) { return service.crear(clase); }
    @PutMapping("/{id}") public ClaseGrupal actualizar(@PathVariable("id") String nombre, @RequestBody ClaseGrupal clase) { return service.actualizar(nombre, clase); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable("id") String nombre) { service.eliminar(nombre); }
    @PutMapping("/{id}/inscribir") public ClaseGrupal inscribir(@PathVariable("id") String nombre) { return service.inscribir(nombre); }
    @PutMapping("/{id}/cancelar-inscripcion") public ClaseGrupal cancelar(@PathVariable("id") String nombre) { return service.cancelarInscripcion(nombre); }
    @GetMapping("/con-cupos") public List<ClaseGrupal> conCupos() { return service.conCupos(); }
}
