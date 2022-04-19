import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../services/api.service';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {
  orderedItemDetails: any;
  order: any;
  userName: any;
  details: any;
  delteteorderDetails: any;

  constructor(private router: Router, private apiservice: ApiService, private orderservice: OrderService) { }
  ngOnInit(): void {
    // this.userName = sessionStorage.getItem("useremail");
    // this.orderDetails = JSON.parse(localStorage.getItem("orderDetails") as any);
    // this.details = sessionStorage.getItem('orderdetails1')
    // this.  = JSON.parse(this.details);
    // console.log(this.orderedItemDetails);
    this.getAllOrders();
  }
  getAllOrders() {
    this.orderservice.getAllOrderUsingtoken().subscribe((res: any) => {
      this.orderedItemDetails = res[0];
    })
  }

  logout() {
    alert("Do you want to logout");
    this.router.navigateByUrl("openingpage");
  }
  billinform(orderId: any) {
    //this.router.navigateByUrl("bill");
    console.log(orderId);
    this.apiservice.getbilldetails('createbillusingOrderId/' + orderId.orderId).subscribe(res => {
      console.log(res);
      this.order = res;
      sessionStorage.setItem("billdetails", JSON.stringify(res));
      // this.apiservice.setBillInfo(JSON.stringify(res));
      //  alert("Do you want to Order this Item");
      this.router.navigateByUrl("bill");

    })
  }

  deleteOrderById(value: any) {
    this.orderservice.deleteOrderByOrderId("orders/" + value.orderId).subscribe(
      (res) => {
        console.log(res);
        alert(" Deleted successfuly!");
        //       this.getItemsByResname();
        this.delteteorderDetails = res;
        //       this.deleteitem = this.restaurentdelteteDetails?.items;
      },
      err => {
        console.log(err);
      }
    )
  }
}

