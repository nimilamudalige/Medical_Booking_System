package lk.ijse.medicalbookingsystem.controller;

import lk.ijse.medicalbookingsystem.dto.ClientDTO;
import lk.ijse.medicalbookingsystem.service.impl.ClientServiceImpl;
import lk.ijse.medicalbookingsystem.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping(path = "save")
   public Response saveClient(@RequestBody ClientDTO clientDTO) {
       clientService.saveClient(clientDTO);
       return new Response(200, "success", null);
   }

   @GetMapping(path = "getAll")
   public Response getAllClients() {
       return new Response(200, "success", clientService.getAllClients());
   }

   @PutMapping
   public Response updateClient(@RequestBody ClientDTO clientDTO) {
       clientService.updateClient(clientDTO);
       return new Response(200, "success", null);
   }

   @DeleteMapping("/{id}")
   public Response deleteClient(@PathVariable UUID id) {
       clientService.deleteClient(id);
       return new Response(200, "success", null);
   }
}
