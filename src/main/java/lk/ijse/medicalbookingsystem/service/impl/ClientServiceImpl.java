package lk.ijse.medicalbookingsystem.service.impl;

import lk.ijse.medicalbookingsystem.dto.ClientDTO;
import lk.ijse.medicalbookingsystem.entity.Client;
import lk.ijse.medicalbookingsystem.repo.ClientRepository;
import lk.ijse.medicalbookingsystem.service.ClientService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void saveClient(ClientDTO clientDTO) {
        if (clientRepo.existsById(String.valueOf(clientDTO.getClientId()))) {
            throw new RuntimeException("Client already exists");
        }
        clientRepo.save(modelMapper.map(clientDTO, Client.class));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return modelMapper.map(
                clientRepo.findAll(),
                new TypeToken<List<ClientDTO>>() {}.getType());

    }

    @Override
    public void updateClient(ClientDTO clientDTO) {
        if (clientRepo.existsById(String.valueOf(clientDTO.getClientId()))) {
            clientRepo.save(modelMapper.map(clientDTO, Client.class));
        }
        throw new RuntimeException("Customer does not exist");

    }

    @Override
    public void deleteClient(UUID id) {
        if (clientRepo.existsById(String.valueOf(id))) {
            clientRepo.deleteById(String.valueOf(id));
        }
        throw new RuntimeException("Customer does not exist");
    }
}
