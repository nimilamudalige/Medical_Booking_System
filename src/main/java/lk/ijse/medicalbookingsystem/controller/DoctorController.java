package lk.ijse.medicalbookingsystem.controller;

import lk.ijse.medicalbookingsystem.dto.DoctorDTO;
import lk.ijse.medicalbookingsystem.service.impl.DoctorServiceImpl;
import lk.ijse.medicalbookingsystem.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    @Autowired
    private DoctorServiceImpl doctorService;

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response saveDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorService.saveDoctor(doctorDTO);
        return new Response(201, "Doctor is saved", null);
    }

    @GetMapping(path = "getAll")
    public Response getAllDoctors() {
        return new Response(200, "success", doctorService.getAllDoctors());
    }

    @PutMapping(path = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response updateDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorService.updateDoctor(doctorDTO);
        return new Response(200, "Doctor is updated", null);
    }

    @DeleteMapping(path = "delete/{id}")
    public Response deleteDoctor(@PathVariable("id") UUID id) {
        doctorService.deleteDoctor(id);
        return new Response(200, "Doctor is deleted", null);
    }
}