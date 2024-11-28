package com.siman.dcastro.marvel.services;

import java.util.List;
import java.util.Optional;

import com.siman.dcastro.marvel.models.dto.UserDto;
import com.siman.dcastro.marvel.models.entities.User;
import com.siman.dcastro.marvel.models.request.UserRequest;

public interface UserService {
    
    List<UserDto> findAll();

    Optional<UserDto> findById(Long id);

    UserDto save(User user);
    Optional<UserDto> update(UserRequest user, Long id);

    void remove(Long id);
}
