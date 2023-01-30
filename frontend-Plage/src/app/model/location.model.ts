import { Concessionnaire } from './concessionnaire.model';
import { Locataire } from './locataire.model';
import { Parasol } from './parasol.model';
import { Statut } from './statut.model';

export class Location {
  id!: number;
  dateHeureDebut!: Date;
  dateHeureFin!: Date;
  montantAReglerEnEuros!: number;
  remarques!: string;
  locataire!: Locataire;
  statut!: Statut;
  concessionnaire!: Concessionnaire;
  parasols!: Parasol[];
}
