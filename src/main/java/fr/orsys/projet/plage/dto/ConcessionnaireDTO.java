package fr.orsys.projet.plage.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConcessionnaireDTO extends UtilisateurDTO{

	String numeroDeTelephone;
}
