package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Habilidad;
import java.util.List;

/**
 *
 * @author Alumno
 */
public interface IHabilidadService {

    public void deleteHabilidad(Long id);
    
    public void editHabilidad(Long id, Habilidad habilidad);
    
    public void newHabilidad(Habilidad habilidad);
    
    public Habilidad verHabilidad(Long id);
    
    public List<Habilidad> verHabilidades();
}
