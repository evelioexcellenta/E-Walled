package id.co.bsi.e_walled.controller;

import id.co.bsi.e_walled.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public WalletResponseDTO create(@RequestBody WalletRequestDTO request) {
        return walletService.createWallet(request);
    }

    @GetMapping("/{id}")
    public WalletResponseDTO getById(@PathVariable Long id) {
        return walletService.getWalletById(id);
    }

    @GetMapping("/account/{accountNumber}")
    public WalletResponseDTO getByAccount(@PathVariable String accountNumber) {
        return walletService.getByAccountNumber(accountNumber);
    }
}
