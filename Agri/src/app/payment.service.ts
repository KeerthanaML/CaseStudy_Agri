import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PaymentTransaction } from './payment-form/payment-model';
//import { PaymentTransaction } from './payment-transaction-model'; // Define the PaymentTransaction model
 
@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private apiUrl = 'http://localhost:8084/api/payments/process'; // Adjust the URL accordingly
 
  constructor(private http: HttpClient) {}
 
  processPayment(payment: PaymentTransaction): Observable<PaymentTransaction> {
    return this.http.post<PaymentTransaction>(this.apiUrl, payment);
  }
}