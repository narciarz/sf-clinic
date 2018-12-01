package com.mawi.sfclinic.repositories;

import com.mawi.sfclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
