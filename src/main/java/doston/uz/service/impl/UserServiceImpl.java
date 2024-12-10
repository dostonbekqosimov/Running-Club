package doston.uz.service.impl;

import doston.uz.dto.RegistrationDTO;
import doston.uz.model.Role;
import doston.uz.model.UserEntity;
import doston.uz.repository.RoleRepository;
import doston.uz.repository.UserRepository;
import doston.uz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository repository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(RegistrationDTO registerDTO) {
        UserEntity user = new UserEntity();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Role role = roleRepository.findByName("USER");

        user.setRoles(Collections.singletonList(role));
        userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
