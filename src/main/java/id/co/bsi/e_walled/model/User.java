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
    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 70)
    private String fullname;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, columnDefinition = "text")
    private String password;

    @Column(name = "avatar_url", columnDefinition = "text")
    private String avatarUrl; // optional

    
}
