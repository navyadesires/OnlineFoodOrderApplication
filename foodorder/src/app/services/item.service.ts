import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  url = "http://localhost:8080/items/";

  constructor(private http: HttpClient) { }

  updateById(value: any, changedVal: any) {
    return this.http.put(this.url + value, changedVal);
  }
  deleteItem(value: any) {
    return this.http.delete(this.url + value);
  }
}
