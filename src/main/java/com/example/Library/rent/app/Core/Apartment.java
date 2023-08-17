package com.example.Library.rent.app.Core;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "APARTMENT")
public class Apartment {

    public int id;
    public String name;
    public double price;
    public double size;
    public String description;

    @Id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

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
