package Controllers;

import Entities.Student;
import Model.StudentCreateModel;
import Repositories.StudentsRepo;
import Service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentsRepo studentsRepo;
    private final StudentService studentService;


    @PostMapping("create")
    public Student createStudent(@RequestBody StudentCreateModel studentCreateModel) {
        return studentService.createStudent(studentCreateModel);
    }

    @GetMapping("/find")
    public List<Student> getstudent() {
        return studentsRepo.findAll();
    }


    @PutMapping("studentupdate/Id")
    public ResponseEntity<Student> studentupdate(@PathVariable Integer Id, @RequestBody StudentCreateModel studentCreateModel){
        return studentService.studentupdate(Id,studentCreateModel);
    }

    @DeleteMapping("studentdelete/Id")
    public  ResponseEntity<Student> studentdelete(@PathVariable("Id") Integer Id){
        return studentService.studentdelete(Id);
    }
}


