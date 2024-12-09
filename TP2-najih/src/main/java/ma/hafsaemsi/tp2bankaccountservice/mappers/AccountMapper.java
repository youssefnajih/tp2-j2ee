package ma.hafsaemsi.tp2bankaccountservice.mappers;

import ma.hafsaemsi.tp2bankaccountservice.dto.BankAccountResponseDTO;
import ma.hafsaemsi.tp2bankaccountservice.entities.BankAccount;
import org.apache.catalina.mbeans.MBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
    BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
    BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
    return bankAccountResponseDTO;
}

}
