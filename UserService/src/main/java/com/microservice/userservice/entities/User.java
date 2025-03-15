package com.microservice.userservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "micro_users")
public class User {

    @Id
    private String userId;

    private String name;

    private String email;

    @Column(length = 100)
    private String about;

    // more user props can be added
    // @Transient field will not be stored in the database
    @Transient
    private List<Rating> ratings;


}
