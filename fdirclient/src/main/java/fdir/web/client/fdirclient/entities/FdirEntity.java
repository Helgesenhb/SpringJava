package fdir.web.client.fdirclient.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class FdirEntity {

    @Id
    private String id;
    
    @ElementCollection
    private List<BusinessType> businessTypes;

    @JsonProperty("versionRegisteredTime")
    private LocalDateTime versionRegisteredTime;

    // Constructors, getters, and setters
    public FdirEntity() {
    }

    public FdirEntity(String id, List<BusinessType> businessTypes) {
        this.id = id;
        this.businessTypes = businessTypes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BusinessType> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<BusinessType> businessTypes) {
        this.businessTypes = businessTypes;
    }

    
    public LocalDateTime getVersionRegisteredTime() {
        return versionRegisteredTime;
    }

    public void setVersionRegisteredTime(LocalDateTime versionRegisteredTime) {
        this.versionRegisteredTime = versionRegisteredTime;
    }
}
