package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Educacion;
import com.devTN.portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    EducacionRepository educacionRepository;
    
    @Override
    public void deleteEducacion(Long id) {
        educacionRepository.deleteById(id);
    }
    
    @Override
    public void editEducacion(Long id, Educacion educacion) {
        Educacion newEducacion = verEducacion(id);
        newEducacion.setId(id);
        newEducacion.setCarrera(educacion.getCarrera());
        newEducacion.setEstablecimiento(educacion.getEstablecimiento());
        newEducacion.setPeriodo(educacion.getPeriodo());
        newEducacion.setTitulo(educacion.getTitulo());
        newEducacion.setUsuario(educacion.getUsuario());
        educacionRepository.save(newEducacion);
    }
    
    @Override
    public void newEducacion(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    @Override
    public Educacion verEducacion(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Educacion> verEducaciones() {
        return educacionRepository.findAll();
    }
}
