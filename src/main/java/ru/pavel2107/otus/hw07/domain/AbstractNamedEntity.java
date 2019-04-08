package ru.pavel2107.otus.hw07.domain;


import org.springframework.data.annotation.AccessType;

import javax.persistence.*;

@MappedSuperclass
@AccessType( AccessType.Type.FIELD)
public abstract class AbstractNamedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name="id", nullable = false)
    protected Long ID;

    @Column( name = "name")
    protected String name;

    public AbstractNamedEntity(){}


    public AbstractNamedEntity(Long ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public boolean isNew(){
        return ID == null;
    }

}
