package lk.ijse.medicalbookingsystem.service;

import lk.ijse.medicalbookingsystem.dto.CheckUpDTO;
import lk.ijse.medicalbookingsystem.dto.DoctorDTO;

import java.util.List;
import java.util.UUID;

public interface CheckUpService {
    void saveCheckUp(CheckUpDTO checkUpDTO);
    List<CheckUpDTO> getAllCheckUps();
    void updateCheckUp(CheckUpDTO checkUpDTO);
    void deleteCheckUp(UUID id);
}
