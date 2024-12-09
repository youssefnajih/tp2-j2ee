package ma.hafsaemsi.tp2bankaccountservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.hafsaemsi.tp2bankaccountservice.dto.BankAccountResponseDTO;
import ma.hafsaemsi.tp2bankaccountservice.dto.BankAccountrequestDTO;
import ma.hafsaemsi.tp2bankaccountservice.entities.BankAccount;
import ma.hafsaemsi.tp2bankaccountservice.entities.Customer;
import ma.hafsaemsi.tp2bankaccountservice.repositories.BankAccountRepository;
import ma.hafsaemsi.tp2bankaccountservice.repositories.CustomerRepository;
import ma.hafsaemsi.tp2bankaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller

public class BankAccountGraphQlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public BankAccount accountsList(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount (@Argument BankAccountrequestDTO bankAccount){
      return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount (@Argument String id,@Argument BankAccountrequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount (@Argument String id){
        bankAccountRepository.deleteById(id);
        return true;

    }
    @QueryMapping
    public List<Customer>customers(){
        return customerRepository.findAll();
    }
}

/*
@Data
@NoArgsConstructor
@AllArgsConstructor
class  BankAccountDTO{
    private String type;
    private Double balance;
    private String currency;


}
record BankAccountDTO(Double balance,String type,String currency){}

*/


