package com.mawi.sfclinic.services.map;

import com.mawi.sfclinic.model.Pet;
import com.mawi.sfclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        super.save(object.getId(), object);
        return object;
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
