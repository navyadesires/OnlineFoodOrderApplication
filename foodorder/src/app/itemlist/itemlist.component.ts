import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { RestaurantService } from '../services/restaurant.service';

@Component({
  selector: 'app-itemlist',
  templateUrl: './itemlist.component.html',
  styleUrls: ['./itemlist.component.scss']
})
export class ItemlistComponent implements OnInit {

  @ViewChild('quantityValueChanged') el: ElementRef;
  itemsList: any[];
  userName: any;
  data: any;
  restarant: any;
  // quantity = 1;
  quantity: any = 1;
  body: any;
  i = 1;
  quantityValue: any;
  changedVal: any;
  constructor(private http: HttpClient, private router: Router, private cartservice: CartService,
    private restaurantservice: RestaurantService) { }


  ngOnInit(): void {
    //   this.route.paramMap.subscribe( params => {
    this.userName = sessionStorage.getItem("useremail");
    const val = sessionStorage.getItem("res")
    this.restarant = JSON.parse(val as any);
    this.getByResId();

  }
  getByResId() {
    this.restaurantservice.getByRestaurantId("getByRestaurantId/" + this.restarant.restaurantId).subscribe((res: any) => {
      this.itemsList = res.items?.map((x: any) => { x.quantity = 1; return x; });
    })
  }
  cartBtn(quantity: any, item: any) {
    console.log(this.el.nativeElement.value);

    console.log(item)
    console.log(quantity.value);
    this.body = {
      "itemId": parseInt(item.itemId),
      "quantity": parseInt(item.quantity)
    }
    console.log(this.body);

    this.cartservice.createcartusingcustNameanditem(this.body).subscribe(x => {

      console.log(x);
      alert("adding item succesfully");
    });
  }

  plusQuantity(cartDetails: any) {
    cartDetails.quantity++;
  }
  minusQuantity(cartDetails: any) {
    if (cartDetails.quantity > 1) {
      cartDetails.quantity--;
    }
  }
  goToCart() {
    this.router.navigateByUrl("cart");
  }
  updateInputValuebyId(i: any) {
  }
}

