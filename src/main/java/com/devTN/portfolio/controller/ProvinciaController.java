package com.devTN.portfolio.controller;
/**
 *
 * @author Tobias Napal
 */

import com.devTN.portfolio.model.Provincia;
import com.devTN.portfolio.service.IProvinciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvinciaController {
    
    @Autowired
    private IProvinciaService provinciaService;
        
    @GetMapping("api/public/get/provincia/{id}")
    @ResponseBody
    public Provincia verProvincia(@PathVariable Long id) {
        return provinciaService.verProvincia(id);
    }
    
    @GetMapping("api/public/get/provincias")
    @ResponseBody
    public List<Provincia> verProvincias() {
        return provinciaService.verProvincias();
    }
   
}
