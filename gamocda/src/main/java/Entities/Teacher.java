package Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Teacher {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tacher_id_seq-generator")
    @SequenceGenerator(name = "teacher_id_seq-generator", sequenceName = "teacher_id_seq", allocationSize = 1)

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

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "Teacher_id", insertable = false, updatable = false)
    private List<Groups> groups;
}

