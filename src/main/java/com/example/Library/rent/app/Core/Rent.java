package com.example.Library.rent.app.Core;

import lombok.*;

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
    private Long id;

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

    public Rent(Long id, int rentTimeInDays, double price) {
        this.id = id;
        this.rentTimeInDays = rentTimeInDays;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return id.equals(rent.id) && rentTimeInDays == rent.rentTimeInDays && Double.compare(rent.price, price) == 0 && Objects.equals(user, rent.user) && Objects.equals(owner, rent.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rentTimeInDays, user, owner, price);
    }
}
