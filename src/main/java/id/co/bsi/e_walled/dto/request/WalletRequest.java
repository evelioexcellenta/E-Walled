package id.co.bsi.e_walled.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class WalletRequest {
    private BigInteger userId;
    private String accountNumber;
    private BigDecimal balance;

}
