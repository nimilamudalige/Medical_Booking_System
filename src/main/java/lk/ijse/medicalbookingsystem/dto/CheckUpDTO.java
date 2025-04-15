package lk.ijse.medicalbookingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckUpDTO {
    private String checkUpId;
    private String name;
    private String type;
    private String image;
    private double price;
    private String duration;
    private String description;
}
