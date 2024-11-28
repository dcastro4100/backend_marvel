package com.siman.dcastro.marvel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siman.dcastro.marvel.models.entities.ApiLogs;

public interface ApiLogRepository extends JpaRepository<ApiLogs, Long> {
}

