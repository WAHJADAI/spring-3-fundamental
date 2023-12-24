package com.tutorial.springfundamental.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "username")
    private  String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @CreationTimestamp
    @Column(name = "created_timestamp")
    private ZonedDateTime createTimestamp;
    @UpdateTimestamp
    @Column(name = "last_updated_timestamp")
    private ZonedDateTime lastUpdateTimestamp;
}
