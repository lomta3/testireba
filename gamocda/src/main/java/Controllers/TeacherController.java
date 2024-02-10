package Controllers;

import Entities.Teacher;
import Model.TeacherCreateModel;
import Repositories.TeacherRepository;
import Service.StudentService;
import Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherRepository teacherRepo;
    private final TeacherService teacherService;

    @PostMapping("/create")
    public Teacher createteacher(@RequestBody TeacherCreateModel teacherCreatModel) {
        return teacherService.createTeacher(teacherCreatModel);
    }

    @GetMapping("/find")
    public List<Teacher> getteacher() {
        return teacherRepo.findAll();
    }

    @PutMapping("/{id}/update")
    public Teacher updateStudent(@PathVariable Integer id, @RequestBody TeacherCreateModel teacherCreateModel) {
        return teacherService.updateTeacherByIdcreateModel(id, teacherCreateModel);
    }
}
