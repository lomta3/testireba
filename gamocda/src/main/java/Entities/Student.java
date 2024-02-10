package Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq-generator")
    @SequenceGenerator(name = "student_id_seq-generator", sequenceName = "student_id_seq", allocationSize = 1)

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "personal_number")
    private Integer personalNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private  String phoneNumber;


}
