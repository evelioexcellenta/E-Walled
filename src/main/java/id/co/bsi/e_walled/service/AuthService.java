package id.co.bsi.e_walled.service;

import id.co.bsi.e_walled.dto.request.LoginRequest;
import id.co.bsi.e_walled.dto.request.RegisterRequest;
import id.co.bsi.e_walled.model.User;
import id.co.bsi.e_walled.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public User register(RegisterRequest registerRequest) {
        Optional<User> checkEmailExist = authRepository.findByEmail(registerRequest.getEmail());
        if (checkEmailExist.isPresent()) {
            throw new RuntimeException("Email Already Exists");
        }
        User user = new User();
        user.setFullname(registerRequest.getFullname());
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword()); // nanti bisa di-hash
        user.setAvatarUrl("https://default-avatar.com/avatar.png");
        return authRepository.save(user);
    }

    public String login(LoginRequest loginRequest) {
//        String token = UUID.randomUUID().toString();
        String token = "absdsadsfbgdfdas";
        Optional<User> checkEmailPassword = authRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (checkEmailPassword.isEmpty()) {
            throw new RuntimeException("Email or Password Incorrect");
        }
        return token;
    }

}

