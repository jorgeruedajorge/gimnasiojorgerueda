package com.rueda.gimnasio.controller;
import com.rueda.gimnasio.model.Socio;
import com.rueda.gimnasio.service.SocioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/socio")
public class SocioController {
    private final SocioService service;
    public SocioController(SocioService service) { this.service = service; }
    @GetMapping public List<Socio> listar() { return service.listar(); }
    @GetMapping("/{id}") public Socio buscar(@PathVariable("id") String nombre) { return service.buscar(nombre); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Socio crear(@RequestBody Socio socio) { return service.crear(socio); }
    @PutMapping("/{id}") public Socio actualizar(@PathVariable("id") String nombre, @RequestBody Socio socio) { return service.actualizar(nombre, socio); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable("id") String nombre) { service.eliminar(nombre); }
    @GetMapping("/ingresos") public double ingresos() { return service.ingresos(); }
    @PutMapping("/{id}/desactivar") public Socio desactivar(@PathVariable("id") String nombre) { return service.desactivar(nombre); }
}
