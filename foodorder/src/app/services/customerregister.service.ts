import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerregisterService {

  url: string = "http://localhost:8080/customer/signup";

  constructor(private http: HttpClient) { }

  onRegister(x: any) {
    return this.http.post(this.url, x);

  }

}
