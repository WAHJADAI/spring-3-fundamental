package com.tutorial.springfundamental.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "keyboard")
@Getter
@Setter
public class KeyboardModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private  int quantity;

    @Column(name ="price" )
    private BigDecimal price;

    @Column(name = "create_timestamp")
    private ZonedDateTime createtimestamp;

    @Column(name = "last_updated_timestamp")
    private ZonedDateTime lastupdatedtimestamp;
}
