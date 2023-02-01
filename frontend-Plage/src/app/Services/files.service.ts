import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, Subject } from 'rxjs';
import { File } from '../models/file.model';

@Injectable({
  providedIn: 'root',
})
export class FilesService {
  private files = new Subject<File[]>();
  private linkFile = 'http://localhost:8080/api/file';

  constructor(private http: HttpClient) {}

  files$ = this.files.asObservable();

  getAllFiles(): Observable<File[]> {
    return this.http.get<File[]>(this.linkFile).pipe(
      map((pays: File[]) => {
        this.files.next(pays);
        return pays;
      })
    );
  }
}
