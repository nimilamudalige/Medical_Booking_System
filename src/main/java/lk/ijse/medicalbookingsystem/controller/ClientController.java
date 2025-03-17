package lk.ijse.medicalbookingsystem.controller;

import lk.ijse.medicalbookingsystem.dto.ClientDTO;
import lk.ijse.medicalbookingsystem.service.impl.ClientServiceImpl;
import lk.ijse.medicalbookingsystem.util.Response;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

   @PostMapping
   public Response saveClient(@RequestBody ClientDTO clientDTO) {
       clientService.saveClient(clientDTO);
       return new Response(200, "success", null);
   }
}
