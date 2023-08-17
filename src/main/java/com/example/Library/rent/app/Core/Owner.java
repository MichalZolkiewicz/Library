package com.example.Library.rent.app.Core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OWNER")
public class Owner {

    private int id;
    private String name;

    @Id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
