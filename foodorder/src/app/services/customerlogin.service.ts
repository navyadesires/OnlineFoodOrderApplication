import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerloginService {
  url = "http://localhost:8080/customer/signIn";

  constructor(private http: HttpClient) { }

  checkCustomerLogin(body: any) {
    return this.http.post(this.url, body, { responseType: "text" });
  }

}


