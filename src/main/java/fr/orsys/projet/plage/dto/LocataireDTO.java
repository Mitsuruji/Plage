package fr.orsys.projet.plage.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocataireDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private LocalDateTime dateHeureInscription;
//    private LienDeParenteDTO lienDeParente;
//    private List<LocationDTO> locations;
//    private PaysDTO pays;

}
