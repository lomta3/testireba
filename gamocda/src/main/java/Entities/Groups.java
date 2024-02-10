package Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Groups {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_id_seq-generator")
    @SequenceGenerator(name = "group_id_seq-generator", sequenceName = "group_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "student_id")
    private  Integer Student_id;

    @Column(name = "teacher_id")
    private  Integer teacher_id;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "Student_id", insertable = false, updatable = false)
    private List<Groups> groups;
}
