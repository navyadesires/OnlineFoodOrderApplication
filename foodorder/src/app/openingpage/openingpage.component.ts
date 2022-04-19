import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-openingpage',
  templateUrl: './openingpage.component.html',
  styleUrls: ['./openingpage.component.scss']
})
export class OpeningpageComponent implements OnInit {

  value = 'Clear me';
  constructor(private router: Router) { }
  ngOnInit(): void {

  }

  customerLogin() {
    this.router.navigateByUrl("customerlogin");
  };
  restaurantLogin() {
    //  alert("restarant person is login");
    this.router.navigateByUrl("restaurantlogin")
  };
  adminlogin() {
    //this.router.navigateByUrl("adminlogin");

  }

}
