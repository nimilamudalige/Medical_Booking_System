//package lk.ijse.medicalbookingsystem.controller;
//
//import lk.ijse.medicalbookingsystem.dto.CheckUpDTO;
//import lk.ijse.medicalbookingsystem.service.impl.CheckupServiceImpl;
//import lk.ijse.medicalbookingsystem.util.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/v1/checkup")
//public class CheckUpController {
//   @Autowired
//    private CheckupServiceImpl checkupService;
//
//
//    @PostMapping(path = "save")
//    public Response saveDoctor(@RequestBody CheckUpDTO checkUpDTO) {
//        checkupService.saveCheckup(checkUpDTO);
//        return new Response(201,"checkUp is saved",null);
//    }
//    @GetMapping(path ="getAll")
//    public Response getAllDoctors() {
//        return new Response(200, "success", checkupService.getCheckUp());
//    }
//
//    @PutMapping(path = "update")
//    public Response updateDoctor(@RequestBody CheckUpDTO checkUpDTO) {
//        checkupService.updateCheckUp(checkUpDTO);
//        return new Response(200,"Checkup is updated",null);
//    }
//    @DeleteMapping(path = "delete/{id}")
//    public Response deleteDoctor(@PathVariable("id") UUID id) {
//        checkupService.deleteCheckUp(id);
//        return new Response(200,"CheckUp is deleted",null);
//    }
//
//}
