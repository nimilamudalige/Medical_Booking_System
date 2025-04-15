package lk.ijse.medicalbookingsystem.service.impl;

import lk.ijse.medicalbookingsystem.dto.CheckUpDTO;
import lk.ijse.medicalbookingsystem.entity.CheckUp;
import lk.ijse.medicalbookingsystem.repo.CheckUpRepository;
import lk.ijse.medicalbookingsystem.service.CheckUpService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CheckupServiceImpl implements CheckUpService {
    @Autowired
    private CheckUpRepository checkUpRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCheckUp(CheckUpDTO checkUpDTO) {
        CheckUp checkUp = modelMapper.map(checkUpDTO, CheckUp.class);
        CheckUp savedCheckUp = checkUpRepo.save(checkUp);
        checkUpDTO.setCheckUpId(String.valueOf(savedCheckUp.getCheckUpId()));
    }

    @Override
    public List<CheckUpDTO> getAllCheckUps() {
        return modelMapper.map(
                checkUpRepo.findAll(),
                new TypeToken<List<CheckUpDTO>>() {}.getType());
    }

    @Override
    public void updateCheckUp(CheckUpDTO checkUpDTO) {
        if (checkUpRepo.existsById(checkUpDTO.getCheckUpId())) {
            checkUpRepo.save(modelMapper.map(checkUpDTO, CheckUp.class));
        } else {
            throw new RuntimeException("CheckUp does not exist");
        }
    }

    @Override
    public void deleteCheckUp(UUID id) {
        if (checkUpRepo.existsById(String.valueOf(id))) {
            checkUpRepo.deleteById(String.valueOf(id));
        } else {
            throw new RuntimeException("CheckUp does not exist");
        }
    }
}