package lk.ijse.medicalbookingsystem.repo;

import lk.ijse.medicalbookingsystem.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Client findByClientId(String clientId);

    boolean existsByEmail(String email);
}
