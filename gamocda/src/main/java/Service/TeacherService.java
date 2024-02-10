package Service;

import Entities.Student;
import Entities.Teacher;
import Model.StudentCreateModel;
import Model.TeacherCreateModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherService {
    Teacher teacheradd(TeacherCreateModel teacherCreateModel);

    Teacher createTeacher(TeacherCreateModel teacherCreatModel);

    Teacher updateTeacherByIdcreateModel(Integer id, TeacherCreateModel teacherCreateModel);
}