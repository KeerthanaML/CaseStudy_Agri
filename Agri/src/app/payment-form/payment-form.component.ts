import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PaymentService } from '../payment.service';
import { PaymentTransaction } from './payment-model';
import Swal from 'sweetalert2';
 
@Component({
  selector: 'app-payment-form',
  templateUrl: './payment-form.component.html',
  styleUrls: ['./payment-form.component.css']
})
export class PaymentFormComponent {
  payment: PaymentTransaction = new PaymentTransaction();
  isSuccess: boolean = false;
 
  constructor(private paymentService: PaymentService, private router: Router) {}
 
  processPayment() {
    this.paymentService.processPayment(this.payment).subscribe(
      (response) => {
        this.payment = response;
        this.isSuccess = response.status === 'SUCCESS';
        Swal.fire({
          title: 'Order Booked Successfully',
          icon: 'success',
        });

        this.router.navigate(['/order-list']);
      },
      (error) => {
        console.error('Error processing payment: ', error);
        this.isSuccess = false;
      }
    );
  }
}