package fdir.web.client.fdirclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdir.web.client.fdirclient.entities.BrregEntity;
import fdir.web.client.fdirclient.entities.FdirEntity;
import fdir.web.client.fdirclient.repositories.BrregEntityRepository;
import fdir.web.client.fdirclient.repositories.FdirEntityRepository;

import java.io.IOException;

@Service
public class EntityService {

    @Autowired
    private FdirEntityRepository fdirEntityRepository;

    @Autowired
    private BrregEntityRepository brregEntityRepository;

    public FdirEntity saveFdirEntity(FdirEntity fdirEntity) throws IOException {
        fdirEntityRepository.save(fdirEntity);
        return fdirEntity;
    }

    public BrregEntity saveBrregEntity(BrregEntity brregEntity) throws IOException {
        brregEntityRepository.save(brregEntity);
        return brregEntity;
    }
}
