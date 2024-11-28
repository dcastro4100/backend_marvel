package com.siman.dcastro.marvel.services.log;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siman.dcastro.marvel.models.entities.ApiLogs;
import com.siman.dcastro.marvel.repositories.ApiLogRepository;

import jakarta.transaction.Transactional;

@Service
public class ApiLogsServiceImpl implements ApiLogsService {

    @Autowired
    private ApiLogRepository repository;

    

    @Override
    public List<ApiLogs> findAll() {
        List<ApiLogs> logs = (List<ApiLogs>) repository.findAll();
        return logs;
    }


}