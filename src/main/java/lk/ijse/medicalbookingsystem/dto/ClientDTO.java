package lk.ijse.medicalbookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
    private String clientId;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private int contact;
    private String email;
    private String gender;
}
