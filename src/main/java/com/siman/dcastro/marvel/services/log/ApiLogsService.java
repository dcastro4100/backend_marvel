package com.siman.dcastro.marvel.services.log;


import java.util.List;
//import java.util.Optional;

import com.siman.dcastro.marvel.models.entities.ApiLogs;


public interface ApiLogsService {
    
    List<ApiLogs> findAll();

    //Optional<ApiLogs> findByUsername(Long id);

}
