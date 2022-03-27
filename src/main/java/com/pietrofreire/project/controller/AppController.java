package com.pietrofreire.project.controller;

import com.pietrofreire.project.model.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Autowired
    public AppService service;

    @RequestMapping(path = "/CreateNewFile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getCSV() {

        return service.getCSV();
    }

    @RequestMapping(path = "/financialByTrader", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getJSON() {

        return service.getJSON();
    }
}
