package fdir.web.client.fdirclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import fdir.web.client.fdirclient.entities.FdirEntity;
import fdir.web.client.fdirclient.repositories.FdirEntityRepository;

import java.io.IOException;

@Service
public class EntityService {

    @Autowired
    private FdirEntityRepository fdirEntityRepository;

    public FdirEntity saveEntity(String response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FdirEntity[] entities = objectMapper.readValue(response, FdirEntity[].class);
        return fdirEntityRepository.save(entities[0]);
    }

    // Other service methods if needed
}
