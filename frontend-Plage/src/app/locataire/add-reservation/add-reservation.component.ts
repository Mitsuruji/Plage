import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FilesService } from 'src/app/services/files.service';
import { File } from 'src/app/models/file.model';

@Component({
  selector: 'app-add-reservation',
  templateUrl: './add-reservation.component.html',
  styleUrls: ['./add-reservation.component.css'],
})
export class AddReservationComponent {
  reservationForm!: FormGroup;
  files!: File[];

  constructor(
    private formBuilder: FormBuilder,
    private fileService: FilesService
  ) {}

  ngOnInit() {
    this.reservationForm = this.formBuilder.group({
      startDate: [null, Validators.required],
      endDate: [null, Validators.required],
      parasols: this.formBuilder.array([this.createParasol()]),
      comments: null,
    });
    this.fileService.getAllFiles().subscribe({
      next: (response) => {
        this.files = response as File[];
        console.log(this.files);
      },
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
