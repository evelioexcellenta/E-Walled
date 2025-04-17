package id.co.bsi.e_walled.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String fullname;
    private String email;
    private String password;
    private String avatarUrl;
}
