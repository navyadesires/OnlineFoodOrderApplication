import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
//import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  // env = environment;
  url: string = "http://localhost:8080/bills/";
  billInfo: any;

  constructor(private http: HttpClient) { }

  getbilldetails(value: any) {
    return this.http.post(this.url + value, {});
  }
  setBillInfo(value: any) {
    this.billInfo = value;
  }
  getBillInfo() {
    return this.billInfo;
  }
}
