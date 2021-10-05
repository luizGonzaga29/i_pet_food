import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'

const url = 'http://localhost:8080/cliente'

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  create(data: any): Observable<any> {
    return this.http.post(url, data);
  }
}
