package ma.hafsaemsi.tp2bankaccountservice.repositories;

import ma.hafsaemsi.tp2bankaccountservice.entities.BankAccount;
import ma.hafsaemsi.tp2bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
@RestResource(path = "/byType")
List<BankAccount> findByType(@Param("t") AccountType type);
}
