package ma.hafsaemsi.tp2bankaccountservice.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.hafsaemsi.tp2bankaccountservice.dto.BankAccountResponseDTO;
import ma.hafsaemsi.tp2bankaccountservice.dto.BankAccountrequestDTO;
import ma.hafsaemsi.tp2bankaccountservice.entities.BankAccount;
import ma.hafsaemsi.tp2bankaccountservice.mappers.AccountMapper;
import ma.hafsaemsi.tp2bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountrequestDTO bankAccountDTO) {
        BankAccount bankAccount =BankAccount.builder().id(UUID.randomUUID().toString())
                .createAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount=bankAccountRepository.save(bankAccount);
      BankAccountResponseDTO bankAccountResponseDTO= accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
    @Override
    public BankAccountResponseDTO updateAccount(String id,BankAccountrequestDTO bankAccountDTO) {
        BankAccount bankAccount =BankAccount.builder().id(id)
                .createAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount=bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO= accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
}
