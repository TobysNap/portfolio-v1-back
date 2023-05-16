package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Habilidad;
import com.devTN.portfolio.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alumno
 */
@Service
public class HabilidadService implements IHabilidadService {
    
    @Autowired
    HabilidadRepository habilidadRepository;
    
    @Override
    public void deleteHabilidad(Long id) {
        habilidadRepository.deleteById(id);
    }

    @Override
    public void editHabilidad(Long id, Habilidad habilidad) {
        Habilidad hab = habilidadRepository.findById(id).orElse(null);
        hab.setId(id);
        hab.setNombre(habilidad.getNombre());
        hab.setDescripcion(habilidad.getDescripcion());
        hab.setPuntaje(habilidad.getPuntaje());
        hab.setTipoHabilidad(habilidad.getTipoHabilidad());
        hab.setUsuario(habilidad.getUsuario());
        habilidadRepository.save(hab);
    }

    @Override
    public void newHabilidad(Habilidad habilidad) {
        habilidadRepository.save(habilidad);
    }

    @Override
    public Habilidad verHabilidad(Long id) {
        return habilidadRepository.findById(id).orElse(null);
    }

    @Override
    public List<Habilidad> verHabilidades() {
        return habilidadRepository.findAll();
    }
    
}
