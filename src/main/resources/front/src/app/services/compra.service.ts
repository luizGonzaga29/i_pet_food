import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { Racao } from '../shared/racao'

const url = 'http://localhost:8080/racao'

@Injectable({
  providedIn: 'root'
})
export class CompraService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Racao[]> {
    return this.http.get<Racao[]>(url);
  }
}
