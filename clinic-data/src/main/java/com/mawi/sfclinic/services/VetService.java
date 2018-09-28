package com.mawi.sfclinic.services;

import com.mawi.sfclinic.model.Vet;

import java.util.Set;

public interface VetService {


    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
