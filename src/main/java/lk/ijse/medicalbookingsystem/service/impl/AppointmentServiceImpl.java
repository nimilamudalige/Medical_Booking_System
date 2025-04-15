//package lk.ijse.medicalbookingsystem.service.impl;
//
//import lk.ijse.medicalbookingsystem.dto.AppointmentDTO;
//import lk.ijse.medicalbookingsystem.entity.Appointment;
//import lk.ijse.medicalbookingsystem.entity.Client;
//import lk.ijse.medicalbookingsystem.repo.AppointmentRepository;
//import lk.ijse.medicalbookingsystem.repo.ClientRepository;
//import lk.ijse.medicalbookingsystem.service.AppointmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class AppointmentServiceImpl implements AppointmentService {
//
//    @Autowired
//    private AppointmentRepository appointmentRepository;
//
//    @Autowired
//    private ClientRepository clientRepository;
//
//    @Override
//    @Transactional
//    public void saveAppointment(AppointmentDTO appointmentDTO) {
//        // Save client details
//        Client client = new Client();
//        client.setFirstName(appointmentDTO.getClientFirstName());
//        client.setLastName(appointmentDTO.getClientLastName());
//        client.setAge(appointmentDTO.getClientAge());
//        client.setAddress(appointmentDTO.getClientAddress());
//        client.setContactNo(appointmentDTO.getClientContactNo());
//        client.setEmail(appointmentDTO.getClientEmail());
//        client.setGender(appointmentDTO.getClientGender());
//        clientRepository.save(client);
//
//        // Save appointment details
//        Appointment appointment = new Appointment();
//        appointment.setAppointmentType(appointmentDTO.getAppointmentType());
//        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
//        appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
//        appointment.setAmount(appointmentDTO.getAmount());
//        appointment.setClient(client); // Link the client to the appointment
//        appointmentRepository.save(appointment);
//    }
//}
package lk.ijse.medicalbookingsystem.service.impl;

import lk.ijse.medicalbookingsystem.dto.AppointmentDTO;
import lk.ijse.medicalbookingsystem.entity.Appointment;
import lk.ijse.medicalbookingsystem.entity.Client;
import lk.ijse.medicalbookingsystem.repo.AppointmentRepository;
import lk.ijse.medicalbookingsystem.repo.ClientRepository;
import lk.ijse.medicalbookingsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public void saveAppointment(AppointmentDTO appointmentDTO) {
        // Save client details
        Client client = new Client();
        client.setClientId(appointmentDTO.getClientId());
        client.setFirstName(appointmentDTO.getClientFirstName());
        client.setLastName(appointmentDTO.getClientLastName());
        client.setAge(appointmentDTO.getClientAge());
        client.setAddress(appointmentDTO.getClientAddress());
        client.setContactNo(appointmentDTO.getClientContactNo());
        client.setEmail(appointmentDTO.getClientEmail());
        client.setGender(appointmentDTO.getClientGender());
        clientRepository.save(client);

        // Save appointment details
        Appointment appointment = new Appointment();
        appointment.setAppointmentType(appointmentDTO.getAppointmentType());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
        appointment.setAmount(appointmentDTO.getAmount());
        appointment.setClient(client);
        appointmentRepository.save(appointment);
    }
}