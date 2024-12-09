package ma.hafsaemsi.tp2bankaccountservice.web;

import ma.hafsaemsi.tp2bankaccountservice.dto.BankAccountResponseDTO;
import ma.hafsaemsi.tp2bankaccountservice.dto.BankAccountrequestDTO;
import ma.hafsaemsi.tp2bankaccountservice.entities.BankAccount;
import ma.hafsaemsi.tp2bankaccountservice.mappers.AccountMapper;
import ma.hafsaemsi.tp2bankaccountservice.repositories.BankAccountRepository;
import ma.hafsaemsi.tp2bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
   private AccountMapper accountMapper;
    public  AccountRestController (BankAccountRepository bankAccountRepository,AccountMapper accountMapper,AccountService accountService){
        this.bankAccountRepository=bankAccountRepository;
        this.accountService=accountService;
        this.accountMapper=accountMapper;

    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("account %s not found",id) ));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountrequestDTO requestDTO){
      return accountService.addAccount(requestDTO);

    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@RequestBody String id,@RequestBody BankAccount bankAccount){
       BankAccount account=bankAccountRepository.findById(id)
               .orElseThrow();
      if (account.getBalance()!=null) account.setBalance(bankAccount.getBalance());
      if (account.getCreateAt()!=null)  account.setCreateAt(new Date());
      if (account.getType()!=null)account.setType(bankAccount.getType());
      if (account.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());
      return bankAccountRepository.save(account);

    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
         bankAccountRepository.deleteById(id);
    }
}
