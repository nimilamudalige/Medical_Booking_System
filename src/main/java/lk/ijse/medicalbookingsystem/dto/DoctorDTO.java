package lk.ijse.medicalbookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO {
  private String docId;
  private String name;
  private String email;
  private String contact;
  private String about;
  private String department;
  private String workingHours;
  private double charge;
  private String image;

}
