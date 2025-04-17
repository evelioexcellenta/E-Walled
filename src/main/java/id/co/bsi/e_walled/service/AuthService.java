package id.co.bsi.e_walled.service;

import id.co.bsi.e_walled.dto.request.RegisterRequest;
import id.co.bsi.e_walled.model.Auth;
import id.co.bsi.e_walled.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public Auth register(RegisterRequest registerRequest) {


        Auth auth = new Auth();
        auth.setName(registerRequest.getName());
        auth.setEmail(registerRequest.getEmail());
        auth.setPassword(registerRequest.getPassword()); // nanti bisa di-hash
        auth.setPhone(registerRequest.getPhone());
        auth.setAvatarUrl("https://default-avatar.com/avatar.png");

        return authRepository.save(auth);
    }

}

