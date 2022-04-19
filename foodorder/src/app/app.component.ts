import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'onlinefda';
  userName: any;
  constructor(private http: HttpClient) { }
  ngOnInit(): void {

  }
  ngOnChanges() {
    this.userName = sessionStorage.getItem("useremail");

  }
  logout() {
    sessionStorage.clear();
  }
  ngAfterViewInit() {
    setTimeout(() => {
      this.userName = sessionStorage.getItem("useremail");
    }, 1000);
  }
}
