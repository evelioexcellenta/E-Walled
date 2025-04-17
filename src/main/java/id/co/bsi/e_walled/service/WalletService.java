package id.co.bsi.e_walled.service;

import id.co.bsi.e_walled.dto.request.WalletRequest;
import id.co.bsi.e_walled.dto.response.WalletResponse;
import id.co.bsi.e_walled.model.Wallet;
import id.co.bsi.e_walled.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public WalletResponse createWallet(WalletRequest request) {
        Wallet wallet = new Wallet();
        wallet.setUserId(request.getUserId());
        wallet.setAccountNumber(request.getAccountNumber());
        wallet.setBalance(request.getBalance());

        Wallet saved = walletRepository.save(wallet);
        return mapToResponseDTO(saved);
    }

    public WalletResponse getWalletById(BigInteger id) {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        return mapToResponseDTO(wallet);
    }

    public WalletResponse getByAccountNumber(String accountNumber) {
        Wallet wallet = walletRepository.findByAccountNumber(accountNumber);
        if (wallet == null) {
            throw new RuntimeException("Wallet not found");
        }
        return mapToResponseDTO(wallet);
    }

    private WalletResponse mapToResponseDTO(Wallet wallet) {
        WalletResponse dto = new WalletResponse();
        dto.setId(wallet.getId());
        dto.setUserId(wallet.getUserId());
        dto.setAccountNumber(wallet.getAccountNumber());
        dto.setBalance(wallet.getBalance());
        dto.setCreatedAt(wallet.getCreatedAt());
        dto.setUpdatedAt(wallet.getUpdatedAt());
        return dto;
    }
}
