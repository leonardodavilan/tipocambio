package com.leonardo.davila.bfftipocambiomoneda.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmoneda;
    @Column
    private String code;
    @Column
    private String name;
}
