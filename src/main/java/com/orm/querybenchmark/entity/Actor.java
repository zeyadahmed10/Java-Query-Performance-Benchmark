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
public class Actor {
    @Id
    @Column(name = "actor_id", nullable = false)
    private Integer id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "actors")
    private Set<Film> films = new HashSet<Film>();
}
