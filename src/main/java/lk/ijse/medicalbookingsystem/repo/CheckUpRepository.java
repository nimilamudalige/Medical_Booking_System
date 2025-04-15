package lk.ijse.medicalbookingsystem.repo;

import lk.ijse.medicalbookingsystem.entity.CheckUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckUpRepository extends JpaRepository<CheckUp,String> {
    boolean existsById(String s);

    void deleteById(String s);

}
