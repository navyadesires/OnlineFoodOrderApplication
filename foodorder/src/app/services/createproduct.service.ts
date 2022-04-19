import { HttpClient, HttpErrorResponse, HttpHeaders, } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CreateproductService {
  url: string = "http://localhost:8080/items/addItems/";
  userName: any;
  constructor(private http: HttpClient) { }
  createItem(x: any) {
    this.userName = sessionStorage.getItem("useremail");
    return this.http.post(this.url + this.userName, x);

  }
}

// import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
// import { Injectable } from '@angular/core';
// import { Observable, throwError } from 'rxjs';
// import { map, catchError, timeout } from 'rxjs/operators';
// import { environment } from 'src/environments/environment';

// @Injectable({
//   providedIn: 'root'
// })
// export class CreateproductService {
//   private CONFIG: any;
//   httpOptions = {
//     headers: new HttpHeaders({
//       'Content-Type': 'application/json'
//     })
//   }
//   userName: any;
//   constructor(private httpClient: HttpClient) {
//     this.CONFIG = environment;
//   }

//   createItem(item: any) {

//     // this.userName = sessionStorage.getItem("useremail");
//     // return this.http.post(this.url + this.userName, x);

//     return this.httpClient.post(this.CONFIG.baseUrl + '/items/createItems', JSON.stringify(item), this.httpOptions)
//       .pipe(
//         catchError(this.errorHandler)
//       )
//   }
//   // errorHandler(errorHandler: any): import("rxjs").OperatorFunction<Object, any> {
//   //   throw new Error('Method not implemented.');
//   // }


//   errorHandler(error: { error: { message: string; }; status: any; message: any; }) {
//     let errorMessage = '';
//     if (error.error instanceof ErrorEvent) {
//       // Get client-side error
//       errorMessage = error.error.message;
//     } else {
//       // Get server-side error
//       errorMessage = `incomplete`;
//     }
//     console.log(errorMessage);
//     return throwError(errorMessage);
//   }

// }

