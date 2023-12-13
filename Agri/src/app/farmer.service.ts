import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FarmerService {
  [x: string]: any;

  private apiURL = 'http://localhost:8081/api/farmers';  // Adjust if needed

  constructor(private http: HttpClient) { }

  getAllFarmers(): Observable<any[]> {
    return this.http.get<any[]>(this.apiURL);
  }

  getFarmerById(id: string): Observable<any> {
    return this.http.get<any>(`${this.apiURL}/${id}`);
  }

  createFarmer(farmer: any): Observable<any> {
    return this.http.post(this.apiURL, farmer);
  }

  updateFarmer(id: string, farmer: any): Observable<any> {
    return this.http.put(`${this.apiURL}/${id}`, farmer);
  }

  deleteFarmer(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiURL}/${id}`);
  }
}
