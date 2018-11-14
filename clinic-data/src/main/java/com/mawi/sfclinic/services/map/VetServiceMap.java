package com.mawi.sfclinic.services.map;

import com.mawi.sfclinic.model.Speciality;
import com.mawi.sfclinic.model.Vet;
import com.mawi.sfclinic.services.SpecialityService;
import com.mawi.sfclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialties().size()>0) {
            object.getSpecialties().forEach(speciality -> {
                if(speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        super.save(object);
        return object;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
