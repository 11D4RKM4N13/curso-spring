package com.example.curso.java.spring.cursospring.models;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "createdDate", columnDefinition = "DATETIME", updatable = false, nullable = false)
    private Date createdDate;

    @Column(name = "updateDate", columnDefinition = "DATETIME", updatable = false, nullable = false)
    private Date updateDate;

    @PrePersist
    protected void onCreate()
    {
        updateDate = new Date();
        if (createdDate == null)
        {
            createdDate = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
