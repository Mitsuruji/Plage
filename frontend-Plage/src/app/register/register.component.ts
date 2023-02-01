import { LiensService } from '../services/liens.service';
import { LienDeParente } from './../models/lien-de-parente.model';
import { FilesService } from 'src/app/services/files.service';
import { AuthentificationService } from '../services/authentification.service';
import { Component } from '@angular/core';
import { Pays } from '../models/pays.model';
import { PaysService } from '../services/pays.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  showError = false;
  listPays: any;
  liens: any;
  registrationForm: any;
  router: any;

  constructor(
    private paysService: PaysService,
    private liensService: LiensService,
    private authService: AuthentificationService
  ) {}

  ngOnInit() {
    this.paysService.getAllPays().subscribe({
      next: (response) => {
        this.listPays = response as Pays[];
      },
    });
    this.liensService.getAllLiens().subscribe({
      next: (response) => {
        this.liens = response as LienDeParente[];
        console.log(this.liens);
      },
    });
  }

  onSubmit(f: any) {
    f.value['type'] = 'Locataire';
    console.log(f.value);
    this.authService.register(f.value).subscribe({
      next: (response: any) => {
        localStorage.setItem('myToken', response['token']);
        alert('c bon');
        this.router.navigateByUrl('');
      },
      error: () => {
        this.showError = true;
        f.reset();
      },
    });
  }
}
