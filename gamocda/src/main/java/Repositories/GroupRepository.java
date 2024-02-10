package Repositories;

import Entities.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Groups,Integer> {

    List<Groups> findAllByGroupId(Integer groupId);

    @Repository
    public interface GroupRepository extends JpaRepository<Groups,Integer> {
        List<Groups> findAllById(Integer Id);
    }
}
