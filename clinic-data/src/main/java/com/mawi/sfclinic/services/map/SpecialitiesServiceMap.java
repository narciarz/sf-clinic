package com.mawi.sfclinic.services.map;

import com.mawi.sfclinic.model.Speciality;
import com.mawi.sfclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialitiesServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        super.save(object);
        return object;
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
