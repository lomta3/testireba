package Controllers;

import Entities.Groups;
import Model.GroupAddModel;
import Service.GroupService;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@AllArgsConstructor
@RestController
public class GroupController {

    private final GroupService groupService;

    @PostMapping("groupadd")
    public Groups groupadd(@RequestBody GroupAddModel groupAddModel) {

        return groupService.groupadd(groupAddModel);
    }

    @PutMapping("groupupdate/{Id}")
    public ResponseEntity<Groups> groupupdate(@PathVariable Integer Id, @RequestBody GroupAddModel groupAddModel){
        return groupService.groupupdate(Id,groupAddModel);
    }
    @DeleteMapping("groupdelete/{Id}")
    public  ResponseEntity<Groups> groupdelete(@PathVariable("Id") Integer Id){
        return groupService.groupdelete(Id);
    }

    @GetMapping("searchegroup")
    public List<Groups> search (Integer Id){
        return groupService.searchegroup(Id);
    }
}

