import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, FormBuilder, Validators, RequiredValidator } from '@angular/forms';
import { RestaurantloginService } from '../services/restaurantlogin.service';

@Component({
  selector: 'app-restaurantlogin',
  templateUrl: './restaurantlogin.component.html',
  styleUrls: ['./restaurantlogin.component.scss']
})
export class RestaurantloginComponent implements OnInit {

  constructor(private router: Router, private restaurantloginService: RestaurantloginService) { }
  loginForm: FormGroup;
  data: any;
  myForm: FormGroup;
  emailErrMessage: string = "";
  pwdErrMessage: string = "";

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
  }
  // restaurantLogin() {
  //   this.data = {
  //     "username": this.loginForm.value.username,
  //     "password": this.loginForm.value.password
  //   }
  //   this.restaurantloginService.restaurantLogin(this.loginForm.value.username + "/" + this.loginForm.value.password).subscribe(resp => {
  //     //console.log(this.baseurl + this.loginForm.value.username+ "/" + this.loginForm.value.password );
  //     console.log(resp);
  //     if (resp.includes("login successful")) {
  //       sessionStorage.setItem("useremail", resp?.split("==")[1])
  //       alert("login success")

  //       this.router.navigateByUrl("restauranthome");
  //     }
  //     //else {
  //     //  console.log(this.loginForm.value.username);
  //     //  alert("Login failed relogin")
  //     //}
  //   },
  //     err => {
  //       console.log(err);
  //       alert("Login failed")
  //     }
  //   )
  // }
  restaurantLogin() {
    this.data = {
      "restaurantEmail": this.loginForm.value.username,
      "restaurantPassword": this.loginForm.value.password
    }
    this.restaurantloginService.restaurantLogin(this.data).subscribe(resp => {
      this.emailErrMessage = "";
      this.pwdErrMessage = "";
      if (resp.includes("login successful")) {
        sessionStorage.setItem("useremail", resp?.split("==")[1])
        this.router.navigateByUrl("restauranthome");
      }
      else if (resp.includes("Email is Not Found")) {
        console.log(resp);
        this.emailErrMessage = "Email Not Correct";
      }
      else if (resp.includes("Password is Wrong")) {
        console.log(resp);
        this.pwdErrMessage = " Password is Wrong "
      }
    },
      err => {
        console.log(err);
        alert("Login failed")
      }
    )
  }
  createRAccount() {
    this.router.navigateByUrl("restaurantregister");
  }

  onSubmit() {
    this.restaurantLogin();
  }
}
