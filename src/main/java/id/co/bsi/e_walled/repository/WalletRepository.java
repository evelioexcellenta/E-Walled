package id.co.bsi.e_walled.repository;

import id.co.bsi.e_walled.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByAccountNumber(String accountNumber);
}
