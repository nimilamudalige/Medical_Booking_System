package lk.ijse.medicalbookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO {
  private String name;
  private String email;
  private String contact;
  private String about;
  private String department;
  private String workingHours;
  private double charge;
}
