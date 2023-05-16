package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Proyecto;
import java.util.List;

/**
 *
 * @author Alumno
 */
public interface IProyectoService {
    
    public void deleteProyecto(Long id);
    
    public void editProyecto(Long id, Proyecto proyecto);
    
    public void newProyecto(Proyecto proyecto);
    
    public Proyecto verProyecto(Long id);
    
    public List<Proyecto> verProyectos();    
}
