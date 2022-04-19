import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.scss']
})
export class BillComponent implements OnInit {
  ItemBillDetails: any;
  billdetails: any;
  constructor(private router: Router, private apiService: ApiService) { }

  ngOnInit(): void {
    this.getBillDetails();
  }
  ngAfterContentInit() {
    // this.getBillDetails();
  }
  getBillDetails() {
    setTimeout(() => {
      this.billdetails = sessionStorage.getItem('billdetails');
      this.ItemBillDetails = JSON.parse(this.billdetails);
      console.log(this.ItemBillDetails);

    }, 100);
  }
  // billinform(billId: any) {
  //   this.apiservice.getbilldetails('createbillusingOrderId').subscribe(res => {

  //   })
  // }
}
