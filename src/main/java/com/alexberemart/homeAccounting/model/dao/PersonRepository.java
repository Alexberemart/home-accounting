package com.alexberemart.homeAccounting.model.dao;

import com.alexberemart.homeAccounting.model.domain.AccountingMovement;
import com.alexberemart.homeAccounting.model.domain.AccountingMovementGroupByDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<AccountingMovement, Long> {

    @Query(value = "select v.date as date, sum(v.amount) as amount from AccountingMovement v group by v.date")
    List<AccountingMovementGroupByDate> getAmountGroupByDate();

    List<AccountingMovement> findAllByOrderByDate();

}