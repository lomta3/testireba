package Model;

public record StudentCreateModel(
        String name,
        String lastName,
        Integer personalNumber,

        String email,
        String phoneNumber
        ) {
}
