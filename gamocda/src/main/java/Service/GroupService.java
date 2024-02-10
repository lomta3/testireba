package Service;

import Entities.Groups;
import Model.GroupAddModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
    public interface GroupService {
        Groups groupadd(GroupAddModel groupAddModel);

        ResponseEntity<Groups> groupupdate(Integer Id, GroupAddModel groupAddModel);

        ResponseEntity<Groups> groupdelete(Integer Id);

        List<Groups> searchegroup(Integer Id);
    }

