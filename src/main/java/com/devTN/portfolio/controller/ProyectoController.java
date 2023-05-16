package com.devTN.portfolio.controller;
/**
 *
 * @author Tobias Napal
 */

import com.devTN.portfolio.model.Proyecto;
import com.devTN.portfolio.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectoService;
        
    @DeleteMapping("api/proyecto/delete/{id}")
    public void deleteProyecto(@PathVariable Long id) {
        proyectoService.deleteProyecto(id);
    }

    @GetMapping("api/public/get/proyecto/{id}")
    @ResponseBody
    public Proyecto verProyecto(@PathVariable Long id) {
        return proyectoService.verProyecto(id);
    }
    
    @GetMapping("api/public/get/proyecto")
    @ResponseBody
    public List<Proyecto> verProyectos() {
        return proyectoService.verProyectos();
    }
    
    @PostMapping("api/proyecto/new")
    public void newProyecto(@RequestBody Proyecto proyecto) {
        proyectoService.newProyecto(proyecto);
    }

    @PutMapping("api/proyecto/edit/{id}")
    public void editProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        proyectoService.editProyecto(id, proyecto);
    }
    
}
