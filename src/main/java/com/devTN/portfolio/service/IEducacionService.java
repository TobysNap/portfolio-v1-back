package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {

    public void deleteEducacion(Long id);

    public void editEducacion(Long id, Educacion educacion);
    
    public void newEducacion(Educacion educacion);
    
    public Educacion verEducacion(Long id);
    
    public List<Educacion> verEducaciones();
}
