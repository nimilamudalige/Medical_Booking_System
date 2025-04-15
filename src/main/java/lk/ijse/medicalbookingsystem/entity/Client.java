////package lk.ijse.medicalbookingsystem.entity;
////
////import jakarta.persistence.*;
////import lombok.AllArgsConstructor;
////import lombok.Data;
////import lombok.NoArgsConstructor;
////
////import java.io.Serializable;
////import java.util.List;
////import java.util.UUID;
////
////@AllArgsConstructor
////@NoArgsConstructor
////@Data
////@Entity
////@Table(name = "client")
////public class Client implements Serializable {
////    @Id
////    @GeneratedValue(strategy = GenerationType.UUID)
////    @Column(name = "clientId")
////    private String clientId;
////    private String firstName;
////    private String lastName;
////    private int age;
////    private String address;
////    private String contactNo;
////    private String email;
////    private String gender;
////
////    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    private List<Appointment> appointments;
////}
////
////
//package lk.ijse.medicalbookingsystem.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.UUID;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Client {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long ClientId;
//
//    private String firstName;
//    private String lastName;
//    private int age;
//    private String address;
//    private String contactNo;
//    private String email;
//    private String gender;
//
//
//}
package lk.ijse.medicalbookingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    private String clientId;

    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String contactNo;
    private String email;
    private String gender;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;
}