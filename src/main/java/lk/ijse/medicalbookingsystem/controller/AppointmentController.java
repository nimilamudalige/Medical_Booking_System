//package lk.ijse.medicalbookingsystem.controller;
//
//import lk.ijse.medicalbookingsystem.dto.AppointmentDTO;
//import lk.ijse.medicalbookingsystem.service.AppointmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/appointments")
//public class AppointmentController {
//
//    @Autowired
//    private AppointmentService appointmentService;
//
//    @PostMapping("/confirm")
//    public String confirmAppointment(@RequestBody AppointmentDTO appointmentDTO) {
//        appointmentService.saveAppointment(appointmentDTO);
//        return "Appointment confirmed successfully!";
//    }
//}
package lk.ijse.medicalbookingsystem.controller;

import lk.ijse.medicalbookingsystem.dto.AppointmentDTO;
import lk.ijse.medicalbookingsystem.service.AppointmentService;
import lk.ijse.medicalbookingsystem.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin(origins = "http://localhost:63342")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping(path = "/save")
    public Response saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.saveAppointment(appointmentDTO);
        return new Response(201, "Appointment and client saved successfully", null);
    }
}