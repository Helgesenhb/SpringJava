package fdir.web.client.fdirclient.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BrregEntity {

    @Id
    private String organisasjonsnummer;
    private String navn;

    // Constructors, getters, and setters
    public BrregEntity() {
    }

    public BrregEntity(String organisasjonsnummer, String navn) {
        this.organisasjonsnummer = organisasjonsnummer;
        this.navn = navn;
    }

    public String getOrganisasjonsnummer() {
        return organisasjonsnummer;
    }

    public void setOrganisasjonsnummer(String organisasjonsnummer) {
        this.organisasjonsnummer = organisasjonsnummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
