import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RestaurantregisterService } from '../services/restaurantregister.service';

@Component({
  selector: 'app-restaurantregister',
  templateUrl: './restaurantregister.component.html',
  styleUrls: ['./restaurantregister.component.scss']
})
export class RestaurantregisterComponent implements OnInit {

  constructor(private router: Router, private registerservice: RestaurantregisterService, private formBulidler: FormBuilder) { }
  registerForm: FormGroup;
  data: any;

  ngOnInit(): void {
    customerName:
    this.registerForm = this.formBulidler.group({
      restaurantName: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      restaurantPassword: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(9), Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]],
      restaurantEmail: ['', [Validators.required, Validators.email, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
      restaurantAddress: ['', [Validators.required]],
      restaurantCity: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      restaurantState: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      restaurantcountry: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      restaurantPincode: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(6), Validators.pattern("^[0-9]*$")]],
      restaurantImageName: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      restaurantManagerFirstName: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      restaurantManagerLastName: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      restaurantManagerNumber: ['', [Validators.required, Validators.maxLength(10), Validators.minLength(10), Validators.pattern("^[0-9]*$")]],
      restaurantManagerEmail: ['', [Validators.required, Validators.email, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
      resManagerPwd: ['', [Validators.required, Validators.minLength(6), Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]]
    });

  }

  loginCAccount() {
    this.router.navigateByUrl("restaurantlogin");
  }
  onSubmit() {
    if (this.registerForm.invalid) {
      alert("fill all required fields");
      return;
    }
    this.data = {
      "restaurantName": this.registerForm.value.restaurantName,
      "restaurantPassword": this.registerForm.value.restaurantPassword,
      "restaurantEmail": this.registerForm.value.restaurantEmail,
      "restaurantAddress": this.registerForm.value.restaurantAddress,
      "restaurantCity": this.registerForm.value.restaurantCity,
      "restaurantState": this.registerForm.value.restaurantState,
      "restaurantcountry": this.registerForm.value.restaurantcountry,
      "restaurantPincode": this.registerForm.value.restaurantPincode,
      "restaurantImageName": this.registerForm.value.restaurantImageName,
      "restaurantManagerFirstName": this.registerForm.value.restaurantManagerFirstName,
      "restaurantManagerLastName": this.registerForm.value.restaurantManagerLastName,
      "restaurantManagerNumber": this.registerForm.value.restaurantManagerNumber,
      "restaurantManagerEmail": this.registerForm.value.restaurantManagerEmail,
      "restaurantManagerPassword": this.registerForm.value.restaurantManagerPassword
    }

    this.registerservice.onresRegister(this.data).subscribe(res => {
      alert("restaurent added");
      this.router.navigateByUrl("restaurantlogin");
    }, err => {
      alert("failed")
    });
  }
  keyPressCharacters(event: any) {
    var inp = String.fromCharCode(event.keyCode);
    // Allow numbers, alpahbets, space, underscore
    if (/[a-zA-Z-_ ]/.test(inp)) {
      return true;
    } else {
      event.preventDefault();
      alert("number is not valid");
      return false;
    }
  }
  printnumbers(event: any) {
    var inp = String.fromCharCode(event.keyCode);
    // Allow numbers only 
    if (/[0-9]/.test(inp)) {
      return true;
    } else {
      event.preventDefault();
      alert("alphebetic is not valid");
      return false;
    }
  }

}
