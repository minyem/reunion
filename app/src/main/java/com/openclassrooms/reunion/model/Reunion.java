package com.openclassrooms.reunion.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Model object representing a Reunion
 */
public class Reunion {

    /** Identifier */
    private long id;

    /** Full name */
    private String nameReunion;

    /** Heure */
    private String heureReunion;

    /** Nom Salle */
    private String nameSalleReunion;

    /** mail address participant*/
    private List<String> mailAddresse;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     */
    public Reunion(long id, String nameReunion, String heureReunion, String nameSalleReunion,
                      String[] addEmail) {
        this.id = id;
        this.nameReunion = nameReunion;
        this.heureReunion = heureReunion;
        this.nameSalleReunion = nameSalleReunion;
        this.mailAddresse = Arrays.asList(addEmail);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameReunionameReunion() {
        return nameReunion;
    }

    public void setNameReunionameReunion(String name) {
        this.nameReunion = nameReunion;
    }

    public String getHeureReunionheureReunion() {
        return heureReunion;
    }

    public void setHeureReunion(String heureReunion) {
        this.heureReunion = heureReunion;
    }

    public String getNameSalleReunion() {
        return nameSalleReunion;
    }

    public void setNameSalleReunion(String nameSalleReunion) {
        this.nameSalleReunion = nameSalleReunion;
    }

    public List<String> getMailAddresse() {
        return mailAddresse ;
    }

    public void setMailAddresse(List<String> addEmail) {
        this.mailAddresse = addEmail;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reunion reunion = (Reunion) o;
        return Objects.equals(id, reunion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void remove(Reunion reunion) {
    }

    public void add(Reunion reunion) {
    }
}
