package id.co.bsi.e_walled.service;

import id.co.bsi.e_walled.dto.request.LoginRequest;
import id.co.bsi.e_walled.dto.request.RegisterRequest;
import id.co.bsi.e_walled.model.Auth;
import id.co.bsi.e_walled.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public Auth register(RegisterRequest registerRequest) {
        Optional<Auth> checkEmailExist = authRepository.findByEmail(registerRequest.getEmail());
        if (checkEmailExist.isPresent()) {
            throw new RuntimeException("Email Already Exists");
        }
        Auth auth = new Auth();
        auth.setFullname(registerRequest.getFullname());
        auth.setUsername(registerRequest.getUsername());
        auth.setEmail(registerRequest.getEmail());
        auth.setPassword(registerRequest.getPassword()); // nanti bisa di-hash
        auth.setAvatarUrl("https://default-avatar.com/avatar.png");
        return authRepository.save(auth);
    }

    public String login(LoginRequest loginRequest) {
//        String token = UUID.randomUUID().toString();
        String token = "absdsadsfbgdfdas";
        Optional<Auth> checkEmailPassword = authRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (checkEmailPassword.isEmpty()) {
            throw new RuntimeException("Email or Password Incorrect");
        }
        return token;
    }

}

