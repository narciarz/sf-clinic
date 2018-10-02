package com.mawi.sfclinic.services;

import com.mawi.sfclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

   Owner findByLastName(String lastName);
}
