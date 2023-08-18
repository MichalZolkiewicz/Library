package com.example.Library.rent.app.Core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "USER")
public class User {

    public int id;
    public String name;
    public String lastName;

    @Id
    @Column (name = "ID")
    public int getId() {
        return id;
    }

    @Column (name = "NAME")
    public String getName() {
        return name;
    }

    @Column (name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, id);
    }
}