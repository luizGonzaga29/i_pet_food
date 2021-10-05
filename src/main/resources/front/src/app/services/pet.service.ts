import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const url = 'http://localhost:8080/pet'

@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(private http: HttpClient) { }

  create(data: any): Observable<any> {
    return this.http.post(url, data)
  }
}


