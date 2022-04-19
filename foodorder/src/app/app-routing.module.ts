import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BillComponent } from './bill/bill.component';
import { CartComponent } from './cart/cart.component';
import { CreateitemComponent } from './createitem/createitem.component';

import { CustomerhomeComponent } from './customerhome/customerhome.component';
import { CustomerloginComponent } from './customerlogin/customerlogin.component';
import { CustomerregisterComponent } from './customerregister/customerregister.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { ItemlistComponent } from './itemlist/itemlist.component';
import { ItemsComponent } from './items/items.component';
import { OpeningpageComponent } from './openingpage/openingpage.component';
import { OrdersComponent } from './orders/orders.component';
import { RestauranthomeComponent } from './restauranthome/restauranthome.component';
import { RestaurantitemlistComponent } from './restaurantitemlist/restaurantitemlist.component';
import { RestaurantloginComponent } from './restaurantlogin/restaurantlogin.component';
import { RestaurantregisterComponent } from './restaurantregister/restaurantregister.component';

const routes: Routes = [
  {
    path: "", redirectTo: "openingpage", pathMatch: "full"
  },
  {
    path: "openingpage", component: OpeningpageComponent
  },
  {
    path: "restaurantlogin", component: RestaurantloginComponent
  },
  {
    path: "customerregister", component: CustomerregisterComponent
  },
  {
    path: "customerlogin", component: CustomerloginComponent
  },
  {
    path: "restaurantregister", component: RestaurantregisterComponent
  },
  {
    path: "restauranthome", component: RestauranthomeComponent
  },
  {
    path: "customerhome", component: CustomerhomeComponent
  },
  {
    path: "orders", component: OrdersComponent
  },
  {
    path: "cart", component: CartComponent
  },
  {
    path: "createitem", component: CreateitemComponent
  },
  {
    path: "itemlist", component: ItemlistComponent
  },
  {
    path: "restaurantitemlist", component: RestaurantitemlistComponent
  },
  {
    path: "bill", component: BillComponent
  },
  {
    path: "items", component: ItemsComponent
  },
  {
    path: "footer", component: FooterComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
