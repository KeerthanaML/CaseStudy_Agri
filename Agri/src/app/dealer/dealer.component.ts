import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DealerService } from '../dealer.service';
 
@Component({
  selector: 'app-dealer',
  templateUrl: './dealer.component.html',
  styleUrls: ['./dealer.component.css']
})
export class DealerComponent implements OnInit {
  apiUrl = 'http://localhost:8082/api/dealers';
  dealers!: any[];
  dealer: any = {};
 
  constructor(private dealerService: DealerService, private router: Router) {}
 
  ngOnInit(): void {
    this.getDealers();
  }
 
  getDealers() {
    this.dealerService.getAllDealers().subscribe((data: any) => {
      this.dealers = data;
    });
  }
 
  getDealer(id: string) {
    this.dealerService.getDealer(id).subscribe((data: any) => {
      this.dealer = data;
    });
  }
 
  createDealer() {
    this.dealerService.createDealer(this.dealer).subscribe(() => {
      this.getDealers();
      this.dealer = {};
    });
  }
 
  updateDealer(id: string) {
    this.dealerService.updateDealer(id, this.dealer).subscribe(() => {
      this.getDealers();
      this.dealer = {};
    });
  }
 
  deleteDealer(id: string) {
    this.dealerService.deleteDealer(id).subscribe(() => {
      this.getDealers();
    });
  }
 
  logout() {
    // Perform logout actions here (e.g., clear user session or revoke tokens)
    // Use Angular's Router to navigate to the logout page
    this.router.navigate(['/logout']);
  }
}