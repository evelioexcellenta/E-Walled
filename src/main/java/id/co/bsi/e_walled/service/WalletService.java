package id.co.bsi.e_walled.service;

import id.co.bsi.e_walled.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public WalletResponseDTO createWallet(WalletRequestDTO request) {
        Wallet wallet = new Wallet();
        wallet.setUserId(request.getUserId());
        wallet.setAccountNumber(request.getAccountNumber());
        wallet.setBalance(request.getBalance());

        Wallet saved = walletRepository.save(wallet);
        return mapToResponseDTO(saved);
    }

    public WalletResponseDTO getWalletById(Long id) {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        return mapToResponseDTO(wallet);
    }

    public WalletResponseDTO getByAccountNumber(String accountNumber) {
        Wallet wallet = walletRepository.findByAccountNumber(accountNumber);
        if (wallet == null) {
            throw new RuntimeException("Wallet not found");
        }
        return mapToResponseDTO(wallet);
    }

    private WalletResponseDTO mapToResponseDTO(Wallet wallet) {
        WalletResponseDTO dto = new WalletResponseDTO();
        dto.setId(wallet.getId());
        dto.setUserId(wallet.getUserId());
        dto.setAccountNumber(wallet.getAccountNumber());
        dto.setBalance(wallet.getBalance());
        dto.setCreatedAt(wallet.getCreatedAt());
        dto.setUpdatedAt(wallet.getUpdatedAt());
        return dto;
    }
}
