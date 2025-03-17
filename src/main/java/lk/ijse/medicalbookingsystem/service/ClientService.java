package lk.ijse.medicalbookingsystem.service;

import lk.ijse.medicalbookingsystem.dto.ClientDTO;
import lk.ijse.medicalbookingsystem.repo.ClientRepository;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    void saveClient(ClientDTO clientDTO);
    List<ClientDTO>getAllClients();
    void updateClient(ClientDTO clientDTO);
    void deleteClient(UUID id);

}
