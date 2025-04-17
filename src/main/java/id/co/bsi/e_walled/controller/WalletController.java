package id.co.bsi.e_walled.controller;

import id.co.bsi.e_walled.dto.request.WalletRequest;
import id.co.bsi.e_walled.dto.response.WalletResponse;
import id.co.bsi.e_walled.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public WalletResponsecreate(@RequestBody WalletRequest request) {
        return walletService.createWallet(request);
    }

    @GetMapping("/{id}")
    public WalletResponse getById(@PathVariable BigInteger id) {
        return walletService.getWalletById(id);
    }

    @GetMapping("/account/{accountNumber}")
    public WalletResponse getByAccount(@PathVariable String accountNumber) {
        return walletService.getByAccountNumber(accountNumber);
    }
}
