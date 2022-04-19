import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { ItemService } from '../services/item.service';
import { RestaurantService } from '../services/restaurant.service';

@Component({
  selector: 'app-restaurantitemlist',
  templateUrl: './restaurantitemlist.component.html',
  styleUrls: ['./restaurantitemlist.component.scss']
})
export class RestaurantitemlistComponent implements OnInit {
  itemsList: any[];
  userName: any;
  data: any;
  restaurentDetails: any;
  resItems: any;
  itemName: any;
  deleteitem: any;
  restaurentdelteteDetails: any;
  itemUpdateDetails: any;
  changedValue: any;
  itemlistForm: FormGroup;

  constructor(private http: HttpClient, private restaurantservice: RestaurantService,
    private itemservice: ItemService) { }
  resName: any;
  ngOnInit(): void {
    this.resName = sessionStorage.getItem("useremail");
    this.getItemsByResname();
  }
  deleteItemByItemId(value: any) {
    this.itemservice.deleteItem("deleteById/" + value).subscribe(
      (res) => {
        console.log(res);
        alert(" Deleted successfuly!");
        this.getItemsByResname();
        this.restaurentdelteteDetails = res;
        this.deleteitem = this.restaurentdelteteDetails?.items;
      },
      err => {
        console.log(err);
      }
    )
  }
  getItemsByResname() {
    this.restaurantservice.getItemsByRestaurantName("getRestaurantandItems/" + this.resName).subscribe(
      (res) => {
        // console.log(res);
        this.restaurentDetails = res;
        this.resItems = this.restaurentDetails?.items;
        // alert("Item Deleted successfully");
      },
      err => {
        console.log(err)
      })
  }
  updateBtn(value: any) {
    this.changedValue = {
      "itemName": value.itemName,
      "itemPrice": value.itemPrice,
      "itemDescription": value.itemDescription,
      "itemQuantity": value.itemQuantity
    }

    this.itemservice.updateById("updateById/" + value.itemId, this.changedValue).subscribe(
      (res) => {
        // console.log(res);
        // this.getItemsByResname();
        // this.itemUpdateDetails = res;
        alert("item updated successlly")
      },
      err => {
        console.log(err);
        alert("Failed")
      }
    )
  }

  printCharacters(event: any) {
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

  printNumbers(event: any) {
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
