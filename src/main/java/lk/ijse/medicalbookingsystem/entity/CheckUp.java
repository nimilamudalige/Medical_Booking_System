package lk.ijse.medicalbookingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "checkups")
public class CheckUp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID checkUpId;
    private String name;
    private String type;
    private double price;
    private String duration;
    private String description;

    @OneToMany(mappedBy = "checkUp", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;
}
