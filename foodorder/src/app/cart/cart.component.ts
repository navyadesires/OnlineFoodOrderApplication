import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  cartDetails: any;
  cart: any;
  userName: any;
  cartdelteteDetails: any;
  deleteorder: any;
  quantity: any = 1;
  quantityItem: number = 1;
  shippingAddress: any = "";
  placedObject: any;
  constructor(private router: Router, private http: HttpClient, private orderservice: OrderService,
    private cartservice: CartService) { }

  ngOnInit(): void {
    this.userName = sessionStorage.getItem("useremail");
    const val = sessionStorage.getItem("res")
    this.cart = JSON.parse(val as any);
    this.getcartDetails();
  }
  getcartDetails() {
    this.cartservice.getCartData().subscribe((res: any) => {
      this.cartDetails = res;
    })
  }
  updateQuantity() {
  }
  onOrder(value: any, quantity: any, item: any, totalPrice: any) {
    item.itemQuantity = quantity;
    item.totalPrice = totalPrice;
    console.log(item);
    console.log(quantity);
    this.orderservice.OrderusingCartId('createOrderusingCartId/' + value.cartId, item).subscribe(res => {
      console.log(res);
      this.cart = res;
      sessionStorage.setItem("orderdetails1", JSON.stringify(res));
      this.router.navigateByUrl("orders");
    })


  }
  onOrderusingToken(item: any) {
    this.orderservice.orderUsingtoken(item).subscribe(res => {
      console.log(res);
    })
  }
  plusQuantity(cartDetails: any) {
    cartDetails.quantity++;
    this.updateCart(cartDetails);

  }
  minusQuantity(cartDetails: any) {
    if (cartDetails.quantity > 1) {
      cartDetails.quantity--;
      this.updateCart(cartDetails);
    }
  }

  updateInputValuebyId(cartDetails: any) {
    this.updateCart(cartDetails);
  }

  onDeleteOrder(value: any) {
    this.cartservice.removeCartUsingId(value).subscribe(res => {
      console.log(res);
      alert(" Deleted successfuly!");
      this.cartdelteteDetails = res;
      this.router.navigateByUrl("itemlist");
    },
      err => {
        console.log(err);
      }
    )
  }

  updateCart(cart: any) {
    this.cartservice.updateCart(cart).subscribe(x => {
      console.log(cart);
    })
  }

  placeOrder() {
    const items = this.cartDetails.cartItems.map((cart: any) => {
      const item = {
        "itemDescription": cart.items.itemDescription,
        "itemName": cart.items.itemName,
        "itemPrice": cart.items.itemPrice,
        "itemQuantity": cart.quantity
      }
      return item;

    });
    console.log(items);
    this.placedObject = {
      "placeOrderDto": items,
      "shippingAddress": this.shippingAddress
    }
    this.cartservice.placeOrder(this.placedObject).subscribe(x => {
      this.router.navigateByUrl("orders");
    })
  }
}
