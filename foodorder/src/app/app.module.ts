import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OpeningpageComponent } from './openingpage/openingpage.component';
import { CustomerloginComponent } from './customerlogin/customerlogin.component';
import { RestaurantloginComponent } from './restaurantlogin/restaurantlogin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';

import { MatRadioModule } from '@angular/material/radio';
import { RestaurantregisterComponent } from './restaurantregister/restaurantregister.component';
import { CustomerregisterComponent } from './customerregister/customerregister.component';
import { CustomerhomeComponent } from './customerhome/customerhome.component';
import { RestauranthomeComponent } from './restauranthome/restauranthome.component';
import { CustomerloginService } from './services/customerlogin.service';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantService } from './services/restaurant.service';
import { RestaurantloginService } from './services/restaurantlogin.service';
import { ItemService } from './services/item.service';


import { OrdersComponent } from './orders/orders.component';
import { CartComponent } from './cart/cart.component';
import { RestaurantregisterService } from './services/restaurantregister.service';
import { OrderService } from './services/order.service';
import { CustomerregisterService } from './services/customerregister.service';
import { ApiService } from './services/api.service';
import { ItemlistComponent } from './itemlist/itemlist.component';
import { CreateitemComponent } from './createitem/createitem.component';
import { RestaurantitemlistComponent } from './restaurantitemlist/restaurantitemlist.component';
import { BillComponent } from './bill/bill.component';
import { HeaderComponent } from './header/header.component';
import { HeadingnameComponent } from './headingname/headingname.component';
import { ItemsComponent } from './items/items.component';
import { RestaurantheaderComponent } from './restaurantheader/restaurantheader.component';
import { CustomerheaderComponent } from './customerheader/customerheader.component';
import { FooterComponent } from './footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    OpeningpageComponent,
    CustomerloginComponent,
    RestaurantloginComponent,
    RestaurantregisterComponent,
    CustomerregisterComponent,
    CustomerhomeComponent,
    RestauranthomeComponent,
    OrdersComponent,
    CartComponent,
    ItemlistComponent,
    CreateitemComponent,
    RestaurantitemlistComponent,
    BillComponent,
    HeaderComponent,
    HeadingnameComponent,
    ItemsComponent,
    RestaurantheaderComponent,
    CustomerheaderComponent,
    FooterComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    MatInputModule,
    HttpClientModule,
    MatIconModule,
    MatIconModule,
    MatRadioModule,
    MatFormFieldModule
    // AlertModule.forRoot()
  ],
  providers: [CustomerloginService,
    RestaurantService,
    RestaurantloginService,
    CustomerloginService,
    RestaurantregisterService,
    OrderService,
    ItemService,
    CustomerregisterService,
    ApiService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
