package lk.ijse.medicalbookingsystem.service.impl;

import lk.ijse.medicalbookingsystem.dto.ClientDTO;
import lk.ijse.medicalbookingsystem.entity.Client;
import lk.ijse.medicalbookingsystem.repo.ClientRepository;
import lk.ijse.medicalbookingsystem.service.ClientService;
import org.modelmapper.ModelMapper;
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
        if (clientRepo.existsById(clientDTO.getClientId())) {
            throw new RuntimeException("Client already exists");
        }
        clientRepo.save(modelMapper.map(clientDTO, Client.class));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return null;
    }

    @Override
    public void updateClient(ClientDTO clientDTO) {

    }

    @Override
    public void deleteClient(UUID id) {

    }
}
