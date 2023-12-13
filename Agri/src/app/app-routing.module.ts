import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AllcropsComponent } from './allcrops/allcrops.component';
import { CreateCropComponent } from './create-crop/create-crop.component';
import { CropListComponent } from './crop-list/crop-list.component';
import { CropslistComponent } from './cropslist/cropslist.component';
import { DealerComponent } from './dealer/dealer.component';
import { EditCropComponent } from './edit-crop/edit-crop.component';
import { FarmerComponent } from './farmer/farmer.component';
import { FarmerlistComponent } from './farmerlist/farmerlist.component';
//import { FarmerListComponent } from './farmerlist/farmerlist.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderComponent } from './order/order.component';


import { PaymentFormComponent } from './payment-form/payment-form.component';


import { RegistrationComponent } from './registration/registration.component';


const routes: Routes = [
  { path: 'Home', component: HomeComponent},
  { path: '', redirectTo: '/login', pathMatch: 'full' }, 
 
  { path: 'register', component: RegistrationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'about-us', component: AboutUsComponent},
  {path:'farmer',component:FarmerComponent},
  { path: 'farmerlist', component:FarmerlistComponent},
  {path:'allcrops',component:AllcropsComponent},
  { path: 'create-crop', component: CreateCropComponent },
  { path: 'crop-list', component: CropListComponent },
  { path: 'cropslist', component: CropslistComponent},
  {path:'dealer',component:DealerComponent},
  { path: 'edit-crop/:id', component: EditCropComponent },
  { path: 'payment-form', component: PaymentFormComponent },
  { path: 'order/:cropId', component:OrderComponent },
{path: 'order-list',component:OrderListComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
