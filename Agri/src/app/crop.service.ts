import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class CropService {
  addcrop(value: any) {
    throw new Error('Method not implemented.');
  }
  
  private apiUrl = 'http://localhost:8083/api/crops';

  constructor(private http: HttpClient) { }

  getAllCrops(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getCropsByFarmer(farmerId: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/farmer/${farmerId}`);
  }

  getCropById(id: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  createCrop(crop: any): Observable<any> {
    return this.http.post(this.apiUrl, crop);
  }

  updateCrop(id: string, crop: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, crop);
  }

  deleteCrop(id: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
