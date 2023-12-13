import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl: string = 'http://localhost:8086/user'; // Replace with the actual base URL of your Spring Boot backend

  constructor(private http: HttpClient) { }

  // Registration method
  registerUser(userData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/signup`, userData);
  }


  loginUser(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, user);
  }

 
}
