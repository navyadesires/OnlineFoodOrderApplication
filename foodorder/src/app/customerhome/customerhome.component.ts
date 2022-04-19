import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantService } from '../services/restaurant.service';

@Component({
  selector: 'app-customerhome',
  templateUrl: './customerhome.component.html',
  styleUrls: ['./customerhome.component.scss']
})
export class CustomerhomeComponent implements OnInit {
  cities: any;
  newArray: any;
  citySelected: any;

  constructor(private router: Router, private http: HttpClient, private restaurantservice: RestaurantService) { }
  userName: any;
  restarants: any;
  restarantlists: any;
  rescity: any;
  restarantcitylist: any;
  textmsg: boolean = true;
  restarantResult: any;
  filteredRestaurants: any[];
  temp1: any;
  filterBy: any;
  mySelectCity = null;
  finalSelectCity = new Array;
  finalSelectcityShow: boolean;

  restarantcitylists = [
    "Mumbai",
    "Nellore",
    "Visakhapatnam",
    "kolhapur",
    "Chittoor",
    "Srikakulam",
    "Kakinada",
    "Hyderabad"
  ]
  ngOnInit(): void {
    this.userName = sessionStorage.getItem("useremail");
    this.finalSelectcityShow = false;
    this.getAllRestaurants();
  }

  // getAllRestarents() {
  //   this.http.get("http://localhost:8080/restaurant/getAll").subscribe(res => {
  //     this.restarants = res;
  //   })
  // }

  getAllRestaurants() {
    this.restaurantservice.getRestaurantdetails("getAll").subscribe(
      (res) => {
        console.log(res);
        this.restarants = res;
      })
  }
  getrestaurantByCity(selectedcity: any) {
    console.log(selectedcity);
    this.citySelected = selectedcity;
    this.finalSelectCity = new Array;
    var cityDataObj = {
      "ResturentData": this.restarants
    }
    this.newArray = cityDataObj.ResturentData.filter((el: any) => {
      if (el.restaurantCity == selectedcity) {

        console.log((el.restaurantCity == selectedcity));
        console.log(el);
        this.finalSelectCity.push(el);
        console.log(this.finalSelectCity);
      } else {
        console.log(this.finalSelectCity);
      }

      if (this.finalSelectCity.length > 0) {
        this.finalSelectcityShow = false;
        console.log((el.restaurantCity == selectedcity));
        console.log(el);
      } else {
        this.finalSelectcityShow = true;
      }

    })
  }
  onMenu(res: string) {
    sessionStorage.setItem("res", JSON.stringify(res));
    this.router.navigate(['/itemlist']);
  }
}
