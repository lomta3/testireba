package Model;

public record TeacherCreateModel(
        String name,
        String lastName,
        Integer personalNumber,

        String email,
        String phoneNumber
) {
}
