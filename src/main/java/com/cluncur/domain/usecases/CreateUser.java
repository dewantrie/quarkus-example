package com.cluncur.domain.usecases;

import com.cluncur.domain.dto.CreateUserDTO;
import com.cluncur.domain.models.User;

public interface CreateUser {
    User create(CreateUserDTO user);
}
