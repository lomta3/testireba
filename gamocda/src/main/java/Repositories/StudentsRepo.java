package Repositories;

import Entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Repository
public interface StudentsRepo extends JpaRepository<Student,Integer> {

    @Repository
    public interface StudentRepository extends JpaRepository<Student, Integer> {
        List<Student> findAllByName(String Name);
    }
}