package com.cluncur.data.interfaces;

import com.cluncur.domain.dto.CreateUserDTO;
import com.cluncur.domain.models.User;

public interface UserRepository {
    User findByEmail(String email);
    User create(CreateUserDTO user);
}