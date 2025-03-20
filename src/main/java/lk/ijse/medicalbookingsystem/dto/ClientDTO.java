package lk.ijse.medicalbookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
    private UUID clientId;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private int contact;
    private String email;
    private String gender;
}
