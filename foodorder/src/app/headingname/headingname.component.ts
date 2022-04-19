import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-headingname',
  templateUrl: './headingname.component.html',
  styleUrls: ['./headingname.component.scss']
})
export class HeadingnameComponent implements OnInit {

  userName: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.userName = sessionStorage.getItem("useremail");
  }
  logout() {
    sessionStorage.clear();
  }
}
