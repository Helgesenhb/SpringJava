package fdir.web.client.fdirclient.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fdir.web.client.fdirclient.ClientService;
import fdir.web.client.fdirclient.entities.BrregEntity;
import fdir.web.client.fdirclient.services.EntityService;

@RestController
@RequestMapping("/brreg")
public class BrregController {

    String enhetBaseUrl = "https://data.brreg.no/enhetsregisteret/api/enheter/";

    @Autowired
    private ClientService clientService;

    @Autowired
    private EntityService entityService;

    @GetMapping("/enheter/")
    public String getEnheter() {
        return clientService.getResponse(enhetBaseUrl);
    }

    @GetMapping("/enhet/{id}")
    @ResponseBody
    public BrregEntity getEnheterById(@PathVariable("id") String id) throws IOException {
    
        String enhetIdUrl = enhetBaseUrl + id;
        String response = clientService.getResponse(enhetIdUrl);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response);

        String organisasjonsnummer = rootNode.path("organisasjonsnummer").asText();
        String navn = rootNode.path("navn").asText();

        BrregEntity brregEntity = new BrregEntity(organisasjonsnummer, navn);

        return entityService.saveBrregEntity(brregEntity);
}

    
}
