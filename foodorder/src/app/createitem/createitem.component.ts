import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
//import { Item } from '../model/item';
import { CreateproductService } from '../services/createproduct.service';

@Component({
  selector: 'app-createitem',
  templateUrl: './createitem.component.html',
  styleUrls: ['./createitem.component.scss']
})
export class CreateitemComponent implements OnInit {
  userName: any;
  constructor(private router: Router, private createproductService: CreateproductService, private formBuilder: FormBuilder) { }
  data: any;
  createForm: FormGroup;
  // item: Item;
  ngOnInit(): void {
    this.userName = sessionStorage.getItem("useremail");
    this.createForm = this.formBuilder.group({
      itemName: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      itemPrice: ['', [Validators.required, Validators.pattern("^[0-9]*$")]],
      itemDescription: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]],
      itemImageName: ['', [Validators.required, Validators.pattern("^[A-Za-z]*$")]]

    });
    this.userName = sessionStorage.getItem("useremail");
    //  this.item = new Item();
  }
  onSubmit() {
    if (this.createForm.invalid) {
      alert("fill all required fields");
      return;
    }
    this.data = {
      "itemName": this.createForm.value.itemName,
      "itemPrice": this.createForm.value.itemPrice,
      "itemDescription": this.createForm.value.itemDescription,
      //"itemQuantity": this.createForm.value.itemQuantity,
      "itemImageName": this.createForm.value.itemImageName
    }
    this.createproductService.createItem(this.data).subscribe(res => {
      alert("Item added");
      this.router.navigateByUrl("restaurantitemlist");
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
