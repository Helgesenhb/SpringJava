package fdir.web.client.fdirclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fdir.web.client.fdirclient.ClientService;

@RestController
@RequestMapping("/brreg")
public class BrregController {

    String enhetBaseUrl = "https://data.brreg.no/enhetsregisteret/api/enheter/";

    @Autowired
    private ClientService clientService;

    @GetMapping("/enheter/")
    public String getEnheter() {
        return clientService.getResponse(enhetBaseUrl);
    }

    @GetMapping("/enhet/{id}")
    @ResponseBody
    public String getEnheterById(@PathVariable("id") String id) {
        
        String enhetIdUrl = enhetBaseUrl + id;
        return clientService.getResponse(enhetIdUrl);
    }
    
}
