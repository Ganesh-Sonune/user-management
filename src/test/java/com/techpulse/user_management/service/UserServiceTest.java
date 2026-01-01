package com.techpulse.user_management.service;

import com.techpulse.user_management.dto.LoginRequest;
import com.techpulse.user_management.dto.RegisterRequest;
import com.techpulse.user_management.model.User;
import com.techpulse.user_management.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;


    @InjectMocks
    private UserService userService;

    @Test
    void registerUser_success() {

        RegisterRequest request = new RegisterRequest();
        request.setName("Ganesh");
        request.setEmail("ganesh@test.com");
        request.setPassword("123456");

        userService.register(request);

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void login_success() {

        User user = new User();
        user.setEmail("ganesh@test.com");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setRole("ROLE_USER");

        when(userRepository.findByEmail("ganesh@test.com"))
                .thenReturn(Optional.of(user));

        LoginRequest request = new LoginRequest();
        request.setEmail("ganesh@test.com");
        request.setPassword("123456");

        String token = userService.login(request);

        assertEquals(false, token.isEmpty());
    }

    @Test
    void login_invalidPassword() {

        User user = new User();
        user.setEmail("ganesh@test.com");
        user.setPassword(passwordEncoder.encode("correct-password"));
        user.setRole("ROLE_USER");

        when(userRepository.findByEmail("ganesh@test.com"))
                .thenReturn(Optional.of(user));

        LoginRequest request = new LoginRequest();
        request.setEmail("ganesh@test.com");
        request.setPassword("wrong-password");

        String response = userService.login(request);

        assertEquals("Invalid email or password", response);
    }
}
