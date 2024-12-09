package ma.hafsaemsi.tp2bankaccountservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.hafsaemsi.tp2bankaccountservice.enums.AccountType;

import java.util.Date;

@Entity

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id ;
    private Date createAt ;
    private Double balance ;
    private String currency ;
    @Enumerated(EnumType.STRING)
    private AccountType type ;
    @ManyToOne
    private Customer customer;

}
