import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-reservation',
  templateUrl: './add-reservation.component.html',
  styleUrls: ['./add-reservation.component.css'],
})
export class AddReservationComponent {
  reservationForm!: FormGroup;
  parasolOptions = [
    { value: 'parasol-1', display: 'Parasol 1' },
    { value: 'parasol-2', display: 'Parasol 2' },
    { value: 'parasol-3', display: 'Parasol 3' },
  ];

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.reservationForm = this.formBuilder.group({
      startDate: [null, Validators.required],
      endDate: [null, Validators.required],
      parasols: this.formBuilder.array([this.createParasol()]),
      comments: null,
    });
  }

  createParasol(): FormGroup {
    return this.formBuilder.group({
      parasol: [null, Validators.required],
    });
  }

  get parasols() {
    const parasolsControl = this.reservationForm.get('parasols');
    return parasolsControl instanceof FormArray ? parasolsControl.controls : [];
  }

  addParasol(): void {
    const parasols = this.reservationForm.get('parasols') as FormArray;
    parasols.push(this.createParasol());
  }

  removeParasol(index: number): void {
    const parasols = this.reservationForm.get('parasols') as FormArray;
    parasols.removeAt(index);
  }

  submitHandler() {
    console.log(this.reservationForm.value);
  }
}
