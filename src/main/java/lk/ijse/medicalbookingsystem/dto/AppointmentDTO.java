package lk.ijse.medicalbookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDTO {
    private String appointmentType;
    private String appointmentDate;
    private String appointmentTime;
    private String clientId;
    private String checkupId;
    private double amount;
}
