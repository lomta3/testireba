package Model;

import Entities.Groups;

import java.util.List;

public record GroupAddModel(
        Integer studentid,
        Integer teacherid
) {
    public Integer studentId() {
    }

    public Integer teacherId() {
    }

    public List<Groups> groupId() {
    }
}
