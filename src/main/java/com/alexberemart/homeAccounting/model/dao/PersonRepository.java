package com.alexberemart.homeAccounting.model.dao;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<AccountingMovement, String> {

}