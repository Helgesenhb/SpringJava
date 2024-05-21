package fdir.web.client.fdirclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fdir.web.client.fdirclient.entities.FdirEntity;

public interface FdirEntityRepository extends JpaRepository<FdirEntity, String> {
}
