package com.mawi.sfclinic.services.springdatajpa;

import com.mawi.sfclinic.model.Owner;
import com.mawi.sfclinic.repositories.OwnerRepository;
import com.mawi.sfclinic.repositories.PetRepository;
import com.mawi.sfclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        Owner owner1 = Owner.builder().id(1L).lastName(LAST_NAME).build();
        Owner owner2 = Owner.builder().id(2L).firstName("Barbra").lastName("Streisand").build();
        returnOwnerSet.add(owner1);
        returnOwnerSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(owners, returnOwnerSet);
        assertEquals(2, owners.size());

        verify(ownerRepository).findAll();

    }

    @Test
    void findById() {
        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
        assertEquals(owner, returnOwner);

        verify(ownerRepository).findById(any());

    }

    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);

    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.save(any(Owner.class))).thenReturn(ownerToSave);

        Owner savedOwner = service.save(ownerToSave);

        assertEquals(ownerToSave, savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        Owner ownerToDelete = Owner.builder().id(1L).lastName(LAST_NAME).build();

        service.delete(ownerToDelete);

        verify(ownerRepository).delete(any(Owner.class));
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}