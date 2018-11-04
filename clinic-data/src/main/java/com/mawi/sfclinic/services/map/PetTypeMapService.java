package com.mawi.sfclinic.services.map;

import com.mawi.sfclinic.model.PetType;
import com.mawi.sfclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        super.save(object);
        return object;
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
