package com.siman.dcastro.marvel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.siman.dcastro.marvel.models.entities.ApiLogs;

import com.siman.dcastro.marvel.services.log.ApiLogsService;

@RestController
@RequestMapping("/logs")
public class LogsController {

    @Autowired
    private ApiLogsService service;

    @GetMapping
    public List<ApiLogs> list() {
        return service.findAll();
    }

    // TODO: endpoint para consulta de actividad de usuario especifico


}
