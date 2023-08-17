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
@Table(name = "RENT")
public class Rent {

    private int id;
    private int rentTimeInDays;
    private User user;
    private Owner owner;
    private double price;

    @Id
    public int getId() {
        return id;
    }

    public int getRentTimeInDays() {
        return rentTimeInDays;
    }
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    @ManyToOne
    @JoinColumn(name = "owner_id")
    public Owner getOwner() {
        return owner;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return id == rent.id && rentTimeInDays == rent.rentTimeInDays && Double.compare(rent.price, price) == 0 && Objects.equals(user, rent.user) && Objects.equals(owner, rent.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentTimeInDays, user, owner, price);
    }
}
