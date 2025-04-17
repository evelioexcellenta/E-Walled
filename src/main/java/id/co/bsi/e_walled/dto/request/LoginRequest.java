package id.co.bsi.e_walled.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
