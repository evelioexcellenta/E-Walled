package id.co.bsi.e_walled.controller;

import id.co.bsi.e_walled.dto.request.LoginRequest;
import id.co.bsi.e_walled.dto.request.LogoutRequest;
import id.co.bsi.e_walled.dto.request.RegisterRequest;
import id.co.bsi.e_walled.dto.response.LoginResponse;
import id.co.bsi.e_walled.dto.response.LogoutResponse;
import id.co.bsi.e_walled.dto.response.RegisterResponse;
import id.co.bsi.e_walled.model.User;
import id.co.bsi.e_walled.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired private AuthService authService;

    @PostMapping("/api/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        try {
            String token = authService.login(loginRequest);
            loginResponse.setToken(token);
            loginResponse.setStatus("success");
        }catch (Exception e) {
            loginResponse.setStatus("error");
            loginResponse.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/api/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        try{
            User register = this.authService.register(registerRequest);
            registerResponse.setStatus("success");
            registerResponse.setMessage("Account registered successfully");
        } catch (Exception e){
            registerResponse.setStatus("error");
            registerResponse.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping("/api/logout")
    public ResponseEntity<LogoutResponse> logout(@RequestBody LogoutRequest request) {
        LogoutResponse response = new LogoutResponse();

        if ("absdsadsfbgdfdas".equals(request.getToken())) {
            response.setStatus("success");
            response.setMessage("Logout successful");
            return ResponseEntity.ok(response);
        } else {
            response.setStatus("failed");
            response.setMessage("Invalid token or already logged out");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
