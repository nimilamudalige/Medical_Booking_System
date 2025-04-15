package lk.ijse.medicalbookingsystem.service.impl;

import lk.ijse.medicalbookingsystem.dto.DoctorDTO;
import lk.ijse.medicalbookingsystem.entity.Doctor;
import lk.ijse.medicalbookingsystem.repo.DoctorRepository;
import lk.ijse.medicalbookingsystem.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
        doctorRepo.save(doctor);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return modelMapper.map(
                doctorRepo.findAll(),
                new TypeToken<List<DoctorDTO>>() {}.getType());
    }

    @Override
    public void updateDoctor(DoctorDTO doctorDTO) {
        if (doctorRepo.existsById(doctorDTO.getDocId())) {
            Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
            doctorRepo.save(doctor);
        } else {
            throw new RuntimeException("Doctor does not exist");
        }
    }

    @Override
    public void deleteDoctor(UUID id) {
        if (doctorRepo.existsById(String.valueOf(id))) {
            doctorRepo.deleteById(String.valueOf(id));
        } else {
            throw new RuntimeException("Doctor does not exist");
        }
    }
}