package com.rueda.gimnasio.controller;
import com.rueda.gimnasio.model.Maquina;
import com.rueda.gimnasio.service.MaquinaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/maquina")
public class MaquinaController {
    private final MaquinaService service;
    public MaquinaController(MaquinaService service) { this.service = service; }
    @GetMapping public List<Maquina> listar() { return service.listar(); }
    @GetMapping("/{id}") public Maquina buscar(@PathVariable("id") String nombre) { return service.buscar(nombre); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Maquina crear(@RequestBody Maquina maquina) { return service.crear(maquina); }
    @PutMapping("/{id}") public Maquina actualizar(@PathVariable("id") String nombre, @RequestBody Maquina maquina) { return service.actualizar(nombre, maquina); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable("id") String nombre) { service.eliminar(nombre); }
    @GetMapping("/operativas") public List<Maquina> operativas() { return service.operativas(); }
    @GetMapping("/antiguas") public List<Maquina> antiguas(@RequestParam(defaultValue="5") int anios) { return service.antiguas(anios); }
    @PutMapping("/{id}/mantenimiento") public Maquina mantenimiento(@PathVariable("id") String nombre) { return service.enviarAMantenimiento(nombre); }
}
