package com.cluncur.data.usecases;

import com.cluncur.data.interfaces.UserRepository;
import com.cluncur.domain.dto.CreateUserDTO;
import com.cluncur.domain.models.User;
import com.cluncur.domain.usecases.CreateUser;

public class CreateUserImpl implements CreateUser {
    private final UserRepository userRepository;

    public CreateUserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserDTO user) {
        var temp = this.userRepository.findByEmail(user.getEmail());
        if (temp != null) {
            throw new RuntimeException("Email exists");
        }
        return this.userRepository.create(user);
    }

}
