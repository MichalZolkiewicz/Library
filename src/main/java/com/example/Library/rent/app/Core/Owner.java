package com.example.Library.rent.app.Core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OWNER")
public class Owner {

    private int id;
    private String name;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    @Column (name = "NAME")
    public String getName() {
        return name;
    }
}
