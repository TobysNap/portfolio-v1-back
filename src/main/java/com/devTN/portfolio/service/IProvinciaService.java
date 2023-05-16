package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Provincia;
import java.util.List;

/**
 *
 * @author Alumno
 */
public interface IProvinciaService {
    
    public void deleteProvincia(Long id);
    
    public void editProvincia(Long id, Provincia provincia);
    
    public void newProvincia(Provincia provincia);
    
    public Provincia verProvincia(Long id);
    
    public List<Provincia> verProvincias();    
}
