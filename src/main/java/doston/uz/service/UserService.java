package doston.uz.service;

import doston.uz.dto.RegistrationDTO;
import doston.uz.model.UserEntity;

public interface UserService {
    void saveUser(RegistrationDTO registerDTO);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
