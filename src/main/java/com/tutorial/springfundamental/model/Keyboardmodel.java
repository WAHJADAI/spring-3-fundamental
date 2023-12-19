package com.tutorial.springfundamental.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.TimestampWithTimeZoneJdbcType;

import java.util.UUID;

@Entity
@Table(name = "keyboard")
@Getter
@Setter
public class Keyboardmodel {
    @Id
    @GeneratedValue
    private UUID id;
@Column(name = "name")
    private String name;
@Column(name = "quantity")
    private  int quantity;
@Column(name ="price" )
    private int price;
@Column(name = "create_timestamp")
    private TimestampWithTimeZoneJdbcType createtimestamp;
@Column(name = "last_updated_timestamp")
    private TimestampWithTimeZoneJdbcType lastupdatedtimestamp;
}
