//package lk.ijse.medicalbookingsystem.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class AppointmentDTO {
//    private String appointmentType;
//    private String appointmentDate;
//    private String appointmentTime;
//    private double amount;
//    private String clientId;
//    private String clientFirstName;
//    private String clientLastName;
//    private int clientAge;
//    private String clientAddress;
//    private String clientContactNo;
//    private String clientEmail;
//    private String clientGender;
//}

package lk.ijse.medicalbookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDTO {
    private String appointmentType;
    private String appointmentDate;
    private String appointmentTime;
    private double amount;
    private String clientId;
    private String clientFirstName;
    private String clientLastName;
    private int clientAge;
    private String clientAddress;
    private String clientContactNo;
    private String clientEmail;
    private String clientGender;
}