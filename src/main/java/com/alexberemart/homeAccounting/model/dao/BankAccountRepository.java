package com.alexberemart.homeAccounting.model.dao;

import com.alexberemart.homeAccounting.model.domain.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

    BankAccount findById(Long id);

}