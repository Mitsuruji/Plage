import { Locataire } from './locataire.model';
export class Pays {
  code!: string;
  nom!: string;
  locataires!: Locataire[];
}
