package fdir.web.client.fdirclient.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fdir.web.client.fdirclient.ClientService;
import fdir.web.client.fdirclient.entities.FdirEntity;
import fdir.web.client.fdirclient.services.EntityService;

@RestController
@RequestMapping("/fdir")
public class FdirController {

    String entityBaseUrl = "https://api.fiskeridir.no/pub-aqua/api/v1/entities";
    
    @Autowired
    private ClientService clientService;

    @Autowired
    private EntityService entityService;

    @GetMapping("/entities/")
    public String getEntities() {
        return clientService.getResponse(entityBaseUrl);
    }

    @GetMapping("/entity/{id}")
    public FdirEntity getFdirEntityById(@PathVariable("id") String id) throws IOException {
        String entityIdUrl = entityBaseUrl + "?entity-nr=" + id;
        String response = clientService.getResponse(entityIdUrl);
        return entityService.saveEntity(response);
    }
}
