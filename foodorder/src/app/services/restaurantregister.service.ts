import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RestaurantregisterService {

  url: string = "http://localhost:8080/restaurant/add";

  constructor(private http: HttpClient) { }

  onresRegister(x:any){
    return this.http.post(this.url, x);
 
   }
}
