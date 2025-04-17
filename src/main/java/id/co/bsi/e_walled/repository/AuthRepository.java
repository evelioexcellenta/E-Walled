package id.co.bsi.e_walled.repository;

import id.co.bsi.e_walled.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface  AuthRepository extends JpaRepository<Auth, BigInteger> {
    Optional<Auth> findByEmail(String email);
//    Optional<Auth> findByUsername(String username);
}
