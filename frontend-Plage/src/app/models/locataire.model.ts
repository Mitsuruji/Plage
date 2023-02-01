import { LienDeParente } from './lien-de-parente.model';
import { Pays } from './pays.model';
import { Utilisateur } from './utilisateur.model';

export class Locataire extends Utilisateur {
  pays!: Pays;
  lienDeParente!: LienDeParente[];
}
