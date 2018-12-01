package com.mawi.sfclinic.repositories;

import com.mawi.sfclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
