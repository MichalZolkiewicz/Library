package com.library.copies;

import com.library.titles.Titles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Copy {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "copy_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "title_id")
    private Titles titleId;

    @Column(name = "status")
    private String status;

}
