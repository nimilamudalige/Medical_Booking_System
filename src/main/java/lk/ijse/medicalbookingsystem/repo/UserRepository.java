package lk.ijse.medicalbookingsystem.repo;

import lk.ijse.medicalbookingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String userName);
    boolean existsByEmail(String userName);
    int deleteByEmail(String userName);
}
