package com.mawi.sfclinic.services.map;

import com.mawi.sfclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private static final Long ownerId = 1L;
    private static final String name = "Smith";
    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        //dependency injection instead of spring
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(name).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());

    }

    @Test
    void saveNoId() {
        Owner owner2 = Owner.builder().build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(owner.getId(), ownerId);
    }

    @Test
    void findByLastNameNotFound() {
        Owner foundName = ownerMapService.findByLastName("foo");
        assertNull(foundName);
    }

    @Test
    void findByLastNameFound() {
        Owner foundName = ownerMapService.findByLastName(name);
        assertNotNull(foundName);


        assertEquals(ownerId, foundName.getId());
    }
}