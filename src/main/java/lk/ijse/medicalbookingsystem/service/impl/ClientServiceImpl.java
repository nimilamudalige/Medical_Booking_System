package lk.ijse.medicalbookingsystem.service.impl;

import lk.ijse.medicalbookingsystem.dto.ClientDTO;
import lk.ijse.medicalbookingsystem.entity.Client;
import lk.ijse.medicalbookingsystem.repo.ClientRepository;
import lk.ijse.medicalbookingsystem.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveClient(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        Client savedClient = clientRepository.save(client);
        clientDTO.setClientId(UUID.fromString(savedClient.getClientId()));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientDTO.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public ClientDTO getClientById(UUID clientId) {
//        Optional<Client> optionalClient = clientRepository.findById(clientId);
//        return optionalClient.map(client -> modelMapper.map(client, ClientDTO.class)).orElse(null);
//    }

    @Override
    public void updateClient( ClientDTO clientDTO) {
        if (!clientRepository.existsById(clientDTO.getClientId().toString())) {
            throw new RuntimeException("Client not found with ID: " + clientDTO.getClientId());
        }
        Client client = modelMapper.map(clientDTO, Client.class);
        client.setClientId(clientDTO.getClientId().toString());
        Client updatedClient = clientRepository.save(client);
        clientDTO.setClientId(UUID.fromString(updatedClient.getClientId()));
    }

    @Override
    public void deleteClient(UUID clientId) {
        if (!clientRepository.existsById(String.valueOf(clientId))) {
            throw new RuntimeException("Client not found with ID: " + clientId);
        }
        clientRepository.deleteById(String.valueOf(clientId));
    }
}
