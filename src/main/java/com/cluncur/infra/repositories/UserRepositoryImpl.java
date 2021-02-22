package com.cluncur.infra.repositories;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import com.cluncur.data.interfaces.UserRepository;
import com.cluncur.domain.dto.CreateUserDTO;
import com.cluncur.domain.models.User;
import com.cluncur.infra.entities.UserEntity;

import org.modelmapper.ModelMapper;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    public User findByEmail(String email) {
        var result = UserEntity.find("email", email).firstResult();
        return result == null ? null : modelMapper.map(result, User.class);
    }

    @Override
    @Transactional
    public User create(CreateUserDTO user) {  
        var userEntity = new UserEntity();   
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        userEntity.persist();   
        return modelMapper.map(userEntity, User.class);
    }
    
}
