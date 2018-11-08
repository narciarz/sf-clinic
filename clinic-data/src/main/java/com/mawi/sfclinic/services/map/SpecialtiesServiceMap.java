package com.mawi.sfclinic.services.map;

import com.mawi.sfclinic.model.Specialty;
import com.mawi.sfclinic.services.SpecialtiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtiesServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtiesService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public Specialty save(Specialty object) {
        super.save(object);
        return object;
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
