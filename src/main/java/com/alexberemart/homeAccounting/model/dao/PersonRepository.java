package com.alexberemart.homeAccounting.model.dao;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends CrudRepository<AccountingMovement, Long> {

}