import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  constructor(private http: HttpClient) { }
  accessToken = sessionStorage.getItem('token');
  url = "http://localhost:8080/order/";

  OrderusingCartId(value: any, quantity: any) {
    return this.http.post(this.url + value, quantity);
  }
  orderUsingtoken(value: any) {
    return this.http.post(this.url + "add" + value, '?token=' + this.accessToken);
  }
  getAllOrderUsingtoken() {
    return this.http.get(this.url + '?token=' + this.accessToken);
  }

  deleteOrderByOrderId(value: any) {
    return this.http.delete(this.url + value);
  }
}
