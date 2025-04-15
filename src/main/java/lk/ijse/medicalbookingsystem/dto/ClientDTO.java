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
    private String contactNo;
    private String email;
    private String gender;
}

//"token": "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiVVNFUiIsInN1YiI6Im5pbWlsYUBnbWFpbC5jb20iLCJpYXQiOjE3NDM0MTc5MTMsImV4cCI6MTc0NDQ1NDcxM30.QoV8gOoyxJOrezl5z17M1Jjms5JIS53Vdi5-5VkaEbQLXshYRH2xmKHfGgVX4hmu2GdaXGCHFwA9CBkRXVyHmQ"
