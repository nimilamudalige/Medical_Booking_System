package lk.ijse.medicalbookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckUpDTO {
    private String name;
    private String type;
    private double price;
    private String duration;
    private  String description;
}
