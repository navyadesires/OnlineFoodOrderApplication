import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customerheader',
  templateUrl: './customerheader.component.html',
  styleUrls: ['./customerheader.component.scss']
})
export class CustomerheaderComponent implements OnInit {
  userName: any;
  constructor() { }

  ngOnInit(): void {

    this.userName = sessionStorage.getItem("useremail");
  }
  logout() {
    //  sessionStorage.clear();
  }
}
