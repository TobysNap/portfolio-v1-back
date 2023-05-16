package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Proyecto;
import com.devTN.portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alumno
 */
@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;
    
    @Override
    public void deleteProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public void editProyecto(Long id, Proyecto proyecto) {
        Proyecto newProyecto = proyectoRepository.findById(id).orElse(null);
        newProyecto.setId(id);
        newProyecto.setNombre(proyecto.getNombre());
        newProyecto.setDescripcion(proyecto.getDescripcion());
        newProyecto.setUrl(proyecto.getUrl());
        newProyecto.setImgUrl(proyecto.getImgUrl());
        newProyecto.setUsuario(proyecto.getUsuario());
        proyectoRepository.save(newProyecto);
    }

    @Override
    public void newProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto verProyecto(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Proyecto> verProyectos() {
        return proyectoRepository.findAll();
    }
    
}
