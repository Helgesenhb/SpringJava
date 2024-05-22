package fdir.web.client.fdirclient.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class BusinessType {

    private String typeValue;
    private String name;

    public BusinessType() {
    }

    public BusinessType(String typeValue, String name) {
        this.typeValue = typeValue;
        this.name = name;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
