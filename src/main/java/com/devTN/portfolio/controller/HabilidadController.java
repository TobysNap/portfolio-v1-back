package com.devTN.portfolio.controller;
/**
 *
 * @author Tobias Napal
 */

import com.devTN.portfolio.model.Habilidad;
import com.devTN.portfolio.service.IHabilidadService;
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
public class HabilidadController {
    
    @Autowired
    private IHabilidadService habilidadService;
        
    @DeleteMapping("api/habilidad/delete/{id}")
    public void deleteHabilidad(@PathVariable Long id) {
        habilidadService.deleteHabilidad(id);
    }

    @GetMapping("api/public/get/habilidad/{id}")
    @ResponseBody
    public Habilidad verHabilidad(@PathVariable Long id) {
        return habilidadService.verHabilidad(id);
    }
    
    @GetMapping("api/public/get/habilidad")
    @ResponseBody
    public List<Habilidad> verHabilidades() {
        return habilidadService.verHabilidades();
    }
    
    @PostMapping("api/habilidad/new")
    public void newHabilidad(@RequestBody Habilidad habilidad) {
        habilidadService.newHabilidad(habilidad);
    }

    @PutMapping("api/habilidad/edit/{id}")
    public void editHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidad) {
        habilidadService.editHabilidad(id, habilidad);
    }
    
}
