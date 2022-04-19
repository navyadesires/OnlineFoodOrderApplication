import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  url = 'http://localhost:8080/restaurant/';

  constructor(private http: HttpClient) { }

  getRestaurantdetails(value: any) {
    return this.http.get(this.url + value);
  }
  getItemsByRestaurantName(value: any) {
    return this.http.get(this.url + value);
  }
  deleteItemByRestaurantName(value: any) {
    return this.http.delete(this.url + value);
  }
  getByRestaurantId(value: any) {
    return this.http.get(this.url + value);
  }

  getOrdersByRestaurantName(value: any) {
    return this.http.get(this.url + value);
  }
  getrestaurantAndItemsByCity(value: any) {
    return this.http.get(this.url + "getrestaurantAndItemsByCity/" + value);
  }

}
