package com.devTN.portfolio.controller;
/**
 *
 * @author Tobias Napal
 */

import com.devTN.portfolio.model.Educacion;
import com.devTN.portfolio.service.IEducacionService;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService educacionService;
        
    @DeleteMapping("api/educacion/delete/{id}")
    public void deleteEducacion(@PathVariable Long id) {
        educacionService.deleteEducacion(id);
    }

    @GetMapping("api/public/get/educacion/{id}")
    @ResponseBody
    public Educacion verEducacion(@PathVariable Long id) {
        return educacionService.verEducacion(id);
    }
    
    @GetMapping("api/public/get/educacion")
    @ResponseBody
    public List<Educacion> verEducaciones() {
        return educacionService.verEducaciones();
    }
    
    @PostMapping("api/educacion/new")
    public void newEducacion(@RequestBody Educacion educacion) {
        educacionService.newEducacion(educacion);
    }

    @PutMapping("api/educacion/edit/{id}")
    public void editEducacion(@PathVariable Long id, @RequestBody Educacion educacion) {
        educacionService.editEducacion(id, educacion);
    }
    
}
