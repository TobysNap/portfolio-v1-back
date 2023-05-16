package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Experiencia;
import com.devTN.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alumno
 */

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;
    
    @Override
    public void deleteExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public void editExperiencia(Long id, Experiencia experiencia) {
        Experiencia newExperiencia = this.verExperiencia(id);
        newExperiencia.setId(id);
        newExperiencia.setEstablecimiento(experiencia.getEstablecimiento());
        newExperiencia.setPuesto(experiencia.getPuesto());
        newExperiencia.setTipoEmpleo(experiencia.getTipoEmpleo());
        newExperiencia.setPeriodo(experiencia.getPeriodo());
        newExperiencia.setContactoExperiencia(experiencia.getContactoExperiencia());
        newExperiencia.setUsuario(experiencia.getUsuario());
        this.newExperiencia(newExperiencia);
    }

    @Override
    public void newExperiencia(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }

    @Override
    public Experiencia verExperiencia(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Experiencia> verExperiencias() {
        return experienciaRepository.findAll();
    }
    
}
