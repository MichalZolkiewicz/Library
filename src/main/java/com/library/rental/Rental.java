package com.library.rental;

import com.library.copies.Copy;
import com.library.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Rental {

    @Id
    @NotNull
    @GeneratedValue
    @OneToOne
    @JoinColumn(name = "copy_id")
    private Copy copyId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users userId;

    @Column(name = "rental_date")
    private LocalDate rentalDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

}
