//package lk.ijse.medicalbookingsystem.service.impl;
//
//import lk.ijse.medicalbookingsystem.dto.CheckUpDTO;
//import lk.ijse.medicalbookingsystem.dto.DoctorDTO;
//import lk.ijse.medicalbookingsystem.entity.CheckUp;
//import lk.ijse.medicalbookingsystem.entity.Doctor;
//import lk.ijse.medicalbookingsystem.repo.CheckUpRepository;
//import lk.ijse.medicalbookingsystem.service.CheckUpService;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.xml.crypto.Data;
//import java.util.List;
//import java.util.UUID;
//
//import static org.yaml.snakeyaml.nodes.NodeId.mapping;
//
//@Service
//public class CheckupServiceImpl implements CheckUpService {
//    @Autowired
//    private CheckUpRepository checkUpRepo;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    public void saveCheckUp(CheckUpDTO checkUpDTO) {
////        try{
////            CheckUp checkUp = modelMapper.map(checkUpDTO, CheckUp.class);
////            checkUpRepo.save(checkUp);
////        }catch (Exception e){
////             throw new RuntimeException("An error occurred");
////        }
////
////        }
////    }
////
////    @Override
////    public List<DoctorDTO> getAllDoctors() {
////        return modelMapper.map(
////                checkUpRepo.findAll(),
////                new TypeToken<List<DoctorDTO>>() {}.getType());
////    }
////
////    @Override
////    public void updateDoctor(DoctorDTO doctorDTO) {
////        if (checkUpRepo.(doctorDTO.getDocId())) {
////            checkUpRepo.save(modelMapper.map(doctorDTO, Doctor.class));
////        }
////        throw new RuntimeException("Doctor does not exist");
////
////    }
////
////    @Override
////    public void deleteDoctor(UUID id) {
////        if (checkUpRepo.existsById(String.valueOf(id))) {
////            checkUpRepo.deleteById(String.valueOf(id));
////        }
////        throw new RuntimeException("Doctor does not exist");
////    }
////
//
//    }
//}