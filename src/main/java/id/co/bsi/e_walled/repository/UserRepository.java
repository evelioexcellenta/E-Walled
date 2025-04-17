package id.co.bsi.e_walled.repository;

import id.co.bsi.e_walled.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User> {
}
