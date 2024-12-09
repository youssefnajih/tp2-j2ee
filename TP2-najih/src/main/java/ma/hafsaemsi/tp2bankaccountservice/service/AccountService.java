package ma.hafsaemsi.tp2bankaccountservice.service;

import ma.hafsaemsi.tp2bankaccountservice.dto.BankAccountResponseDTO;
import ma.hafsaemsi.tp2bankaccountservice.dto.BankAccountrequestDTO;
import ma.hafsaemsi.tp2bankaccountservice.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountrequestDTO bankAccountDTO);
     BankAccountResponseDTO updateAccount(String id, BankAccountrequestDTO bankAccountDTO);

}
