import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerloginService } from '../services/customerlogin.service';

@Component({
  selector: 'app-customerlogin',
  templateUrl: './customerlogin.component.html',
  styleUrls: ['./customerlogin.component.scss']
})
export class CustomerloginComponent implements OnInit {
  tokenInfo: any;
  constructor(private router: Router, private customerloginService: CustomerloginService) { }
  loginForm: FormGroup;
  data: any;
  myForm: FormGroup;
  errMessage: string = "";
  pwdErrMessage: string = "";
  accessToken: any;
  ngOnInit(): void {
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
  }

  checkCustomerLogin() {
    this.data = {
      "customerEmail": this.loginForm.value.username,
      "customerPassword": this.loginForm.value.password
    }
    this.customerloginService.checkCustomerLogin(this.data).subscribe((resp) => {
      console.log(resp);
      this.errMessage = "";
      this.pwdErrMessage = "";
      this.accessToken = JSON.parse(resp);
      sessionStorage.setItem("token", this.accessToken.token);
      sessionStorage.setItem("useremail", this.accessToken.customerName)

      if (resp) {
        this.router.navigateByUrl("customerhome");
      }
      // else if (resp.includes("Email is Not Found")) {
      //   console.log(resp);
      //   //  alert(" Email Not Correct");
      //   this.errMessage = "Email Not Correct";
      // }
      // else if (resp.includes("Password is Wrong")) {
      //   console.log(resp);
      //   // alert(" Password is Wrong");
      //   this.pwdErrMessage = "Password is Wrong";
      // }
    },

      err => {
        console.log(err);
        alert("Login failed")
      }
    )
  }
  createCAccount() {
    this.router.navigateByUrl("customerregister");
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      alert("fill all required fields");
      return;
    }
    this.checkCustomerLogin();
  }
  keyPressCharactersforEmail(event: any) {
    var email = String.fromCharCode(event.keyCode);
    if (/[0-9_ ]/.test(email)) {
      return true;
    } else {
      event.preventDefault();
      alert("number is not valid");
      return false;
    }
  }
}