package com.jsonparser.jsonparserdb.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class EClassEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(columnDefinition="TEXT")
    private String description;
}
