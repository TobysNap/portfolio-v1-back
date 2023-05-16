package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Provincia;
import com.devTN.portfolio.repository.ProvinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tobias Napal
 */

@Service
public class ProvinciaService implements IProvinciaService {

    @Autowired
    ProvinciaRepository provinciaRepository;
    
    @Override
    public void deleteProvincia(Long id) {
        provinciaRepository.deleteById(id);
    }

    @Override
    public void editProvincia(Long id, Provincia provincia) {
        Provincia newProvincia = provinciaRepository.findById(id).orElse(null);
        newProvincia.setId(id);
        newProvincia.setNombre(provincia.getNombre());
        provinciaRepository.save(newProvincia);
    }

    @Override
    public void newProvincia(Provincia provincia) {
        provinciaRepository.save(provincia);
    }

    @Override
    public Provincia verProvincia(Long id) {
        return provinciaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Provincia> verProvincias() {
        return provinciaRepository.findAll();
    }
    
}
