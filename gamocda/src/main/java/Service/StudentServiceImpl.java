package Service;

import Entities.Student;
import Model.StudentCreateModel;
import Repositories.StudentsRepo;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentsRepo studentsRepo;

    @Override
    public Student student(StudentCreateModel studentCreateModel) {
        Student students = new Student();
        students.setName(studentCreateModel.name());
        students.setLastName(studentCreateModel.lastName());
        students.setPhoneNumber(studentCreateModel.phoneNumber());
        students.setEmail(studentCreateModel.email());
        students.setPhoneNumber(studentCreateModel.phoneNumber());
        studentsRepo.save(students);

        return students;

    }

    @Override
    public ResponseEntity<Student> studentupdate(Integer Id, StudentCreateModel studentCreateModel) {
        Student studentupdate = studentsRepo.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("not found for this id"));
        studentupdate.setName(studentCreateModel.name());
        studentupdate.setLastName(studentCreateModel.lastName());
        studentupdate.setPersonalNumber(studentCreateModel.personalNumber());
        studentupdate.setEmail(studentCreateModel.email());
        studentupdate.setPhoneNumber(studentCreateModel.phoneNumber());
        studentsRepo.save(studentupdate);

        return ResponseEntity.ok(studentupdate);
    }

    @Override
    public  ResponseEntity<Student> studentdelete(Integer Id) {
        Student studentdelete = studentsRepo.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException(" not found for this id"));
        studentsRepo.deleteById(Id);
        return (ResponseEntity<Student>) ResponseEntity.ok();
    }

    @Override
    public List<Student> searchstudent(String Name) {
        List<Student> allbyname = studentsRepo.findAllBYName(Name);
        return allbyname;
    }
}
