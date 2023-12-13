import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
 
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
// import { AuthService } from './auth.service';
// import { JwtInterceptor } from 'jwt-interceptor';
import { AppRoutingModule } from './app-routing.module';
import { FarmerComponent } from './farmer/farmer.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';

import { AboutUsComponent } from './about-us/about-us.component';
import { FarmerlistComponent } from './farmerlist/farmerlist.component';
import { AllcropsComponent } from './allcrops/allcrops.component';
import { CreateCropComponent } from './create-crop/create-crop.component';
import { CropListComponent } from './crop-list/crop-list.component';
import { DealerComponent } from './dealer/dealer.component';
import { EditCropComponent } from './edit-crop/edit-crop.component';
import { PaymentFormComponent } from './payment-form/payment-form.component';
import { OrderComponent } from './order/order.component';
import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';

import { OrderListComponent } from './order-list/order-list.component';
import { CropslistComponent } from './cropslist/cropslist.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';




//import { FarmerListComponent } from './farmerlist/farmerlist.component';

//import { JwtInterceptor } from './jwt.interceptor';
 
@NgModule({
  declarations: [AppComponent,
     RegistrationComponent,
      LoginComponent, 
      FarmerComponent,
       HomeComponent, 
       HeaderComponent,
        AboutUsComponent, 
        FarmerlistComponent,
        
        AllcropsComponent, 
        CreateCropComponent, 
        CropListComponent,
         DealerComponent, 
         EditCropComponent,
          PaymentFormComponent, 
          OrderComponent, OrderListComponent, CropslistComponent,  ],
  imports: [BrowserModule, 
    HttpClientModule,
    FormsModule,
    RouterModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatToolbarModule,
    MatInputModule,
    MatCardModule,
    MatIconModule,
    MatSelectModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    ],
  providers: [
    // AuthService,
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   // useClass: JwtInterceptor,
    //   multi: true,
    // },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}