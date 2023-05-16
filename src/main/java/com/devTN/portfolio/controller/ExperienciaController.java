package com.devTN.portfolio.controller;
/**
 *
 * @author Tobias Napal
 */

import com.devTN.portfolio.model.Experiencia;
import com.devTN.portfolio.service.IExperienciaService;
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
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService experienciaService;
        
    @DeleteMapping("api/experiencia/delete/{id}")
    public void deleteExperiencia(@PathVariable Long id) {
        experienciaService.deleteExperiencia(id);
    }

    @GetMapping("api/public/get/experiencia/{id}")
    @ResponseBody
    public Experiencia verExperiencia(@PathVariable Long id) {
        return experienciaService.verExperiencia(id);
    }
    
    @GetMapping("api/public/get/experiencia")
    @ResponseBody
    public List<Experiencia> verExperiencias() {
        return experienciaService.verExperiencias();
    }
    
    @PostMapping("api/experiencia/new")
    public void newExperiencia(@RequestBody Experiencia experiencia) {
        experienciaService.newExperiencia(experiencia);
    }

    @PutMapping("api/experiencia/edit/{id}")
    public void editExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia) {
        experienciaService.editExperiencia(id, experiencia);
    }
    
}
