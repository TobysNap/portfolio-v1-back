package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Experiencia;
import java.util.List;

/**
 *
 * @author Alumno
 */
public interface IExperienciaService {
    
    public void deleteExperiencia(Long id);
    
    public void editExperiencia(Long id, Experiencia experiencia);
    
    public void newExperiencia(Experiencia experiencia);
    
    public Experiencia verExperiencia(Long id);
    
    public List<Experiencia> verExperiencias();
            
}
