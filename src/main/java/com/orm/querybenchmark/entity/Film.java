package com.orm.querybenchmark.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Film {
    @Id
    @Column(name = "film_id", nullable = false)
    private Integer id;
    private String title;
    private Integer releaseYear;
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id") ,
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    Set<Actor> actors = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
