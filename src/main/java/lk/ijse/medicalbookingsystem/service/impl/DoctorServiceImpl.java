package lk.ijse.medicalbookingsystem.service.impl;

import lk.ijse.medicalbookingsystem.dto.ClientDTO;
import lk.ijse.medicalbookingsystem.dto.DoctorDTO;
import lk.ijse.medicalbookingsystem.entity.Client;
import lk.ijse.medicalbookingsystem.entity.Doctor;
import lk.ijse.medicalbookingsystem.repo.ClientRepository;
import lk.ijse.medicalbookingsystem.repo.DoctorRepository;
import lk.ijse.medicalbookingsystem.service.ClientService;
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
            if (doctorRepo.existsById(doctorDTO.getDocId())) {
                throw new RuntimeException("Doctor already exists");
            }
            doctorRepo.save(modelMapper.map(doctorDTO, Doctor.class));
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
                doctorRepo.save(modelMapper.map(doctorDTO, Doctor.class));
            }
            throw new RuntimeException("Doctor does not exist");

        }

        @Override
        public void deleteDoctor(UUID id) {
            if (doctorRepo.existsById(String.valueOf(id))) {
                doctorRepo.deleteById(String.valueOf(id));
            }
            throw new RuntimeException("Doctor does not exist");
        }
}
