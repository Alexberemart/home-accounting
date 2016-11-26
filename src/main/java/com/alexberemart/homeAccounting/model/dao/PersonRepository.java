package com.alexberemart.homeAccounting.model.dao;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<AccountingMovement, Long> {

}