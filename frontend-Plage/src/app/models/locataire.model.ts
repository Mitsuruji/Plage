import { LienDeParente } from './lien-de-parente.model';
import { Pays } from './pays.model';
import { Utilisateur } from './utilisateur.model';

export class Locataire extends Utilisateur {
  dateHeureInscription!: Date;
  pays!: Pays;
  lienDeParente!: LienDeParente;
}
