package com.example.Library.rent.app.Core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "APARTMENT")
public class Apartment {

    @Id
    @Column (name = "ID")
    private long id;

    @Column (name = "NAME")
    private String name;

    @Column (name = "PRICE")
    private double price;

    @Column (name = "SIZE")
    private double size;

    @Column (name = "DESCRIPTION")
    private String description;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return id == apartment.id && Double.compare(apartment.price, price) == 0 && Double.compare(apartment.size, size) == 0 && Objects.equals(name, apartment.name) && Objects.equals(description, apartment.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, size, description);
    }
}
