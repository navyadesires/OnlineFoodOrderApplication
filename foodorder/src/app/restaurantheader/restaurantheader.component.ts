import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-restaurantheader',
  templateUrl: './restaurantheader.component.html',
  styleUrls: ['./restaurantheader.component.scss']
})
export class RestaurantheaderComponent implements OnInit {
  userName: any;
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.userName = sessionStorage.getItem("useremail");
  }
  resHome() {
    //   this.router.navigateByUrl("restauranthome");
  }
  logout() {

  }

}
