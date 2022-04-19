import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CartService {
  accessToken: any;
  constructor(private http: HttpClient) { }
  ngOnInit() {
    this.accessToken = sessionStorage.getItem('token');
  }

  host = "http://localhost:8080";
  url = this.host+"/foodcart/";

  getCartData() {
    this.accessToken = sessionStorage.getItem('token');
    return this.http.get(this.url + '?token=' + this.accessToken);
  }
  createcartusingcustNameanditem(body: any) {
    this.accessToken = sessionStorage.getItem('token');
    return this.http.post(this.url + "add" + '?token=' + this.accessToken, body);
  }

  removeCartUsingId(value: any) {
    return this.http.delete(this.url + "delete/" + value + '?token=' + this.accessToken);
  }

  updateCart(cart: any){
    return this.http.put(this.url + "Cart/" + cart.id + '?token=' + this.accessToken, cart);
  }

  placeOrder(items: any){
    return this.http.post(this.host + "/order/add" + '?token=' + this.accessToken, items);
  }

}
