package com.cauapaula.receitas.model;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column (name = "nome", nullable = false)
    private String nome;

    @Column (unique = true, nullable = false)
    private String email;

    private String password;

}
