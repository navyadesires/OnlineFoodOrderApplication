import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerregisterService } from '../services/customerregister.service';

@Component({
  selector: 'app-customerregister',
  templateUrl: './customerregister.component.html',
  styleUrls: ['./customerregister.component.scss']
})
export class CustomerregisterComponent implements OnInit {

  constructor(private router: Router, private customerregister: CustomerregisterService, private formBuilder: FormBuilder) { }
  registerForm: FormGroup;
  data: any;
  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      customerName: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      customerEmail: ['', [Validators.required, Validators.email, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
      customerPassword: ['', [Validators.required, Validators.minLength(9), Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]],
      customerAge: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(2), Validators.pattern("^[0-9]*$")]],
      Mobnum: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10), Validators.pattern("^[0-9]*$")]],
      customerAddress: ['', Validators.required],
      customerCity: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      customerState: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      customerCountry: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      customerPincode: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(6), Validators.pattern("^[0-9]*$")]]
    });
  }
  loginCAccount() {
    this.router.navigateByUrl("customerlogin");
  }
  onSubmit() {
    if (this.registerForm.invalid) {
      alert("fill all required fields");
      return;
    }
    this.data = {
      "customerName": this.registerForm.value.customerName,
      "customerEmail": this.registerForm.value.customerEmail,
      "customerPassword": this.registerForm.value.customerPassword,
      "customerAge": this.registerForm.value.customerAge,
      "customerMobileNumber": this.registerForm.value.Mobnum + "",
      "customerAddress": this.registerForm.value.customerAddress,
      "customerCity": this.registerForm.value.customerCity,
      "customerState": this.registerForm.value.customerState,
      "customerCountry": this.registerForm.value.customerCountry,
      "customerPincode": this.registerForm.value.customerPincode + "",
    }
    //this.router.navigateByUrl("customerhome");
    this.customerregister.onRegister(this.data).subscribe(res => {
      alert("customer added");
      this.router.navigateByUrl("customerlogin");
    }, err => {
      alert("failed please try again")
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

}
