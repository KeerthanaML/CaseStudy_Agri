import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private apiUrl = 'http://localhost:8085/api/orders';
  // getOrders: any;
  // deleteOrder: any;

  constructor(private http: HttpClient) { }

  createOrder(order: any): Observable<any> {
    return this.http.post(this.apiUrl, order);
  }
    // Fetch all orders
   
    getAllOrders(): Observable<any[]> {
      return this.http.get<any[]>(this.apiUrl);
    }
    deleteOrder(id: string): Observable<any> {
      return this.http.delete(`${this.apiUrl}/${id}`);
    }

    
  }

