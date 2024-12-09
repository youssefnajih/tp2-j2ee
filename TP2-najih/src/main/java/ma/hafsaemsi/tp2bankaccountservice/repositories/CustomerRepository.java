package ma.hafsaemsi.tp2bankaccountservice.repositories;

import ma.hafsaemsi.tp2bankaccountservice.entities.BankAccount;
import ma.hafsaemsi.tp2bankaccountservice.entities.Customer;
import ma.hafsaemsi.tp2bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    }
