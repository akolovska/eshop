package mk.finki.ukim.eshop.model.dto;

import mk.finki.ukim.eshop.model.domain.User;

public record RegisterUserRequestDto(
        String name,
        String surname,
        String email,
        String username,
        String password
) {
    public User toUser() {
        return new User(name, surname, email, username, password);
    }
}

