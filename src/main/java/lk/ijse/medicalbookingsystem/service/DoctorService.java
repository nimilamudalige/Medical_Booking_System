package lk.ijse.medicalbookingsystem.service;

import lk.ijse.medicalbookingsystem.dto.ClientDTO;
import lk.ijse.medicalbookingsystem.dto.DoctorDTO;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    void saveDoctor(DoctorDTO doctorDTO);
    List<DoctorDTO> getAllDoctors();
    void updateDoctor(DoctorDTO doctorDTO);
    void deleteDoctor(UUID id);
}
