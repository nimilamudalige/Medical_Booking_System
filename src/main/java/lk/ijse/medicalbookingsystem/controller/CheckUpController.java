package lk.ijse.medicalbookingsystem.controller;

import lk.ijse.medicalbookingsystem.dto.CheckUpDTO;
import lk.ijse.medicalbookingsystem.service.impl.CheckupServiceImpl;
import lk.ijse.medicalbookingsystem.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/checkup")
public class CheckUpController {
    @Autowired
    private CheckupServiceImpl checkupService;

    @PostMapping(path = "/save")
    public Response saveCheckUp(@RequestBody CheckUpDTO checkUpDTO) {
        checkupService.saveCheckUp(checkUpDTO);
        return new Response(201, "CheckUp is saved", null);
    }

    @GetMapping(path = "/getAll")
    public Response getAllCheckUps() {
        return new Response(200, "success", checkupService.getAllCheckUps());
    }

    @PutMapping(path = "/update")
    public Response updateCheckUp(@RequestBody CheckUpDTO checkUpDTO) {
        checkupService.updateCheckUp(checkUpDTO);
        return new Response(200, "CheckUp is updated", null);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Response deleteCheckUp(@PathVariable("id") UUID id) {
        checkupService.deleteCheckUp(id);
        return new Response(200, "CheckUp is deleted", null);
    }
}