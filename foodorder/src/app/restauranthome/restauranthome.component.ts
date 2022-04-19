import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-restauranthome',
  templateUrl: './restauranthome.component.html',
  styleUrls: ['./restauranthome.component.scss']
})
export class RestauranthomeComponent implements OnInit {

  constructor(private router: Router) { }
  userName: any;

  ngOnInit(): void {
    this.userName = sessionStorage.getItem("useremail");
  }

}
