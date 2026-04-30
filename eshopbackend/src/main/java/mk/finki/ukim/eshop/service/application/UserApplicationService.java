package mk.finki.ukim.eshop.service.application;

import mk.finki.ukim.eshop.model.dto.LoginUserRequestDto;
import mk.finki.ukim.eshop.model.dto.LoginUserResponseDto;
import mk.finki.ukim.eshop.model.dto.RegisterUserRequestDto;
import mk.finki.ukim.eshop.model.dto.RegisterUserResponseDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);

}
