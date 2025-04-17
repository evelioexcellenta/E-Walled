package id.co.bsi.e_walled.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String status;
    private String token;
    private String message;
}
