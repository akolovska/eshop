package mk.finki.ukim.eshop.service.application.impl;

import mk.finki.ukim.eshop.helpers.JwtHelper;
import mk.finki.ukim.eshop.model.domain.User;
import mk.finki.ukim.eshop.model.dto.LoginUserRequestDto;
import mk.finki.ukim.eshop.model.dto.LoginUserResponseDto;
import mk.finki.ukim.eshop.model.dto.RegisterUserRequestDto;
import mk.finki.ukim.eshop.model.dto.RegisterUserResponseDto;
import mk.finki.ukim.eshop.service.application.UserApplicationService;
import mk.finki.ukim.eshop.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;
    private final JwtHelper jwtHelper;

    public UserApplicationServiceImpl(UserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto) {
        User user = userService.register(registerUserRequestDto.toUser());
        RegisterUserResponseDto displayUserDto = RegisterUserResponseDto.from(user);
        return Optional.of(displayUserDto);
    }

    @Override
    public Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto) {
        User user = userService.login(loginUserRequestDto.username(), loginUserRequestDto.password());

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginUserResponseDto(token));
    }

    @Override
    public Optional<RegisterUserResponseDto> findByUsername(String username) {
        return userService
                .findByUsername(username)
                .map(RegisterUserResponseDto::from);
    }

}
