package com.perscholas.krishna.saveaccess.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/",
        produces = "application/json",
        method = {RequestMethod.GET, RequestMethod.POST})

public class DocumentsController {
    @Autowired
    private DocumentsController repository;



    }



