package id.co.bsi.e_walled.repository;

import id.co.bsi.e_walled.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface WalletRepository extends JpaRepository<Wallet, BigInteger> {
    Wallet findByAccountNumber(String accountNumber);
}
