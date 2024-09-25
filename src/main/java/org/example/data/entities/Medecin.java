package org.example.data.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Medecin {
    private int id;
    private String nom;
    private String prenom;
    private Medecin medecin;
}
