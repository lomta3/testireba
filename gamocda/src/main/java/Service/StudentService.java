package Service;

import Entities.Student;
import Model.StudentCreateModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<Student> studentdelete(Integer Id);
    List<Student> searchstudent(String firstName);

    Student createStudent(StudentCreateModel studentCreateModel);

    Student student(StudentCreateModel studentCreateModel);

    ResponseEntity<Student> studentupdate(Integer id, StudentCreateModel studentCreateModel);
}


