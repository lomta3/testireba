package Service;

import Entities.Teacher;
import Model.TeacherCreateModel;
import Repositories.TeacherRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    @Override
    public Teacher teacheradd(TeacherCreateModel teacherCreateModel) {
        Teacher teachers = new Teacher();
        teachers.setName(teacherCreateModel.name());
        teachers.setLastName(teacherCreateModel.lastName());
        teachers.setPersonalNumber(teacherCreateModel.personalNumber());
        teachers.setEmail(teacherCreateModel.email());
        teachers.setPhoneNumber(teacherCreateModel.phoneNumber());
        teacherRepository.save(teachers);

        return teachers;
    }

    @Override
    public ResponseEntity<Teacher> teacherupdate(Integer Id, TeacherCreateModel teacherCreateModel) {
        Teacher teacherupdate = teacherRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("not found for this id"));
        teacherupdate.setName(teacherCreateModel.name());
        teacherupdate.setLastName(teacherCreateModel.lastName());
        teacherupdate.setPersonalNumber(teacherCreateModel.personalNumber());
        teacherupdate.setEmail(teacherCreateModel.email());
        teacherupdate.setPhoneNumber(teacherCreateModel.phoneNumber());
        teacherRepository.save(teacherupdate);

        return ResponseEntity.ok(teacherupdate);
    }

    @Override
    public ResponseEntity<Teacher> teachertdelete(Integer Id) {
        Teacher teacherdelete = teacherRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("not found for this id"));
        teacherRepository.deleteById(Id);
        return (ResponseEntity<Teacher>) ResponseEntity.ok();
    }

    @Override
    public List<Teacher> searchteacher(String firstName) {
        List<Teacher> allbyname = teacherRepository.findAllByName(Name);
        return allbyname;
    }
}
