package com.example.Library.rent.app.Core;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "USER")
public class User {

    @Id
    @Column (name = "ID")
    private Long id;

    @Column (name = "NAME")
    private String name;

    @Column (name = "LASTNAME")
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(name, user.name) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, id);
    }
}