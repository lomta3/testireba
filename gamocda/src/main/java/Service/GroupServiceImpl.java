package Service;

import Entities.Groups;
import Model.GroupAddModel;
import Repositories.GroupRepository;
import org.apache.catalina.Group;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    public class GroupServiceImpl implements GroupService {
        private final GroupRepository groupRepository;

        @Override
        public Groups groupadd(GroupAddModel groupAddModel) {
            Groups groups = new Groups();
            groups.setStudent_id(groupAddModel.studentid());
            groups.setTeacher_id(groupAddModel.teacherid());
            groupRepository.save(groups);

            return groups;
        }

        @Override
        public ResponseEntity<Groups> groupupdate(Integer Id, GroupAddModel groupAddModel) {
            Groups groupupdate = groupRepository.findById(Id)
                    .orElseThrow(() -> new ResourceNotFoundException("not found for this id"));
            groupupdate.setGroups(groupAddModel.groupId());
            groupupdate.setStudent_id(groupAddModel.studentId());
            groupupdate.setTeacher_id(groupAddModel.teacherId());
            groupRepository.save(groupupdate);
            return ResponseEntity.ok(groupupdate);
        }

        @Override
        public ResponseEntity<Group> groupdelete(Integer Id) {
            Group groupdelete = groupRepository.findById(Id)
                    .orElseThrow(() -> new ResourceNotFoundException("not found for this id"));
            groupRepository.deleteById(Id);
            return (ResponseEntity<Group>) ResponseEntity.ok();
        }

        @Override
        public List<Group> searchegroup(Integer Id) {
            List<Group> allbyId = groupRepository.findAllById(Id);
            return allbyId;
        }

        @Override
        public List<Groups> searchGroup(Integer groupId) {
            List<Groups> allbyGroup = groupRepository.findAllByGroupId(groupId);
            return allbyGroup;
        }
}
