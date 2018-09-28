package com.mawi.sfclinic.services;

import com.mawi.sfclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

   Owner findByLastName(String lastName);

   Owner findById(Long id);

   Owner save(Owner owner);

   Set<Owner> findAll();
}
