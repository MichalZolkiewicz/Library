package com.example.Library.rent.app.Core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OWNER")
public class Owner {

    @Id
    @Column(name = "ID")
    private int id;

    @Column (name = "NAME")
    private String name;

}
