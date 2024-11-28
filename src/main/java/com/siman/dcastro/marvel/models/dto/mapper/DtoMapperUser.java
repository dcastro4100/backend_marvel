package com.siman.dcastro.marvel.models.dto.mapper;

import com.siman.dcastro.marvel.models.dto.UserDto;
import com.siman.dcastro.marvel.models.entities.User;

public class DtoMapperUser {

    private User user;
    
    private DtoMapperUser() {
    }

    public static DtoMapperUser builder() {
        return new DtoMapperUser();
    }

    public DtoMapperUser setUser(User user) {
        this.user = user;
        return this;
    }

    public UserDto build() {
        if (user == null) {
            throw new RuntimeException("Debe pasar el entity user!");
        }
        return new UserDto(this.user.getId(), user.getUsername(), user.getEmail());
    }
    

}
