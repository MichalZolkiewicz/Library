package com.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Copy {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "copy_id")
    private Long id;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Titles titles;

    public Copy(String status) {
        this.status = status;
    }
}
