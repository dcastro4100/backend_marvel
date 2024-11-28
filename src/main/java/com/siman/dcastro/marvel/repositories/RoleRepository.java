package com.siman.dcastro.marvel.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.siman.dcastro.marvel.models.entities.Role;

public interface RoleRepository
        extends CrudRepository<Role, Long> {
        Optional<Role> findByName(String name);
}
