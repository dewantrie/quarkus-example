package com.cluncur.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.cluncur.data.usecases.CreateUserImpl;
import com.cluncur.domain.dto.CreateUserDTO;
import com.cluncur.domain.models.User;
import com.cluncur.infra.repositories.UserRepositoryImpl;

@ApplicationScoped
public class UserService {
    
    @Inject
    UserRepositoryImpl userRepositoryImpl;

    public User save(CreateUserDTO user) {
        var createUser = new CreateUserImpl(userRepositoryImpl);
        return createUser.create(user);
    }
}
