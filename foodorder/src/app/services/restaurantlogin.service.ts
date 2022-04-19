import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestaurantloginService {

  url = "http://localhost:8080/restaurant/getrestaurantbyemailandpassword"
  constructor(private http: HttpClient) { }

  restaurantLogin(body: any) {
    return this.http.post(this.url, body, { responseType: "text" });
  }

}
