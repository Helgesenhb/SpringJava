package fdir.web.client.fdirclient.controllers;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fdir.web.client.fdirclient.ClientService;
import fdir.web.client.fdirclient.entities.BusinessType;
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

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response).get(0);

        String entityId = rootNode.path("id").asText();
        List<BusinessType> businessTypes = new ArrayList<>();

        JsonNode businessTypesNode = rootNode.path("businessTypes");
        for (JsonNode node : businessTypesNode) {
            String value = node.path("value").asText();
            String name = node.path("name").asText();
            businessTypes.add(new BusinessType(value, name));
        }

        String versionRegisteredTimeStr = rootNode.path("versionRegisteredTime").asText();
        Instant instant = Instant.parse(versionRegisteredTimeStr);
        LocalDateTime versionRegisteredTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

        FdirEntity fdirEntity = new FdirEntity();
        fdirEntity.setId(entityId);
        fdirEntity.setBusinessTypes(businessTypes);
        fdirEntity.setVersionRegisteredTime(versionRegisteredTime);

        return entityService.saveFdirEntity(fdirEntity);
    }
}
