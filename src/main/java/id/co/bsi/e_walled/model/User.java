package id.co.bsi.e_walled.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String fullname;
    private String email;
    private String password;
    private String avatarUrl; // optional
}
