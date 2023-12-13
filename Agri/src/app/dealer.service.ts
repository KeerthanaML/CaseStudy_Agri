import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
 
@Injectable({
  providedIn: 'root'
})
export class DealerService {
  private apiUrl = 'http://localhost:8082/api/dealers'; // Replace with your API URL
 
  constructor(private http: HttpClient) {}
 
  getAllDealers() {
    return this.http.get(this.apiUrl);
  }
 
  getDealer(id: string) {
    return this.http.get(`${this.apiUrl}/${id}`);
  }
 
  createDealer(dealer: any) {
    return this.http.post(this.apiUrl, dealer);
  }
 
  updateDealer(id: string, dealer: any) {
    return this.http.put(`${this.apiUrl}/${id}`, dealer);
  }
 
  deleteDealer(id: string) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}