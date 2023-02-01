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
  registrationForm: any;

  constructor(private paysService: PaysService) {}

  ngOnInit() {
    this.paysService.getAllPays().subscribe({
      next: (response) => {
        this.listPays = response;
        console.log(this.listPays);
      },
    });
  }

  onSubmit() {
    // this.http
    //   .post('url_to_send_data_to', this.registrationForm.value)
    //   .subscribe((res: any) => {
    //     console.log('Form data sent successfully:', res);
    //   });
  }
}
