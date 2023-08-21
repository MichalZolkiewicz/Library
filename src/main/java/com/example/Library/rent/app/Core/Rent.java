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
@Table(name = "RENT")
public class Rent {

    @Id
    @Column (name = "ID")
    private int id;

    @Column (name = "RENT_TIME_IN_DAYS")
    private int rentTimeInDays;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @Column (name = "PRICE")
    private double price;

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
