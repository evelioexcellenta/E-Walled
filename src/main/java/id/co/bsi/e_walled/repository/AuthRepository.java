package id.co.bsi.e_walled.repository;

import id.co.bsi.e_walled.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface  AuthRepository extends JpaRepository<User, BigInteger> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
//    Optional<Auth> findByUsername(String username);
}
