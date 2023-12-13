import { Component, OnInit } from '@angular/core';
import { FarmerService } from '../farmer.service';

@Component({
  selector: 'app-farmerlist',
  templateUrl: './farmerlist.component.html',
  styleUrls: ['./farmerlist.component.css']
})
export class FarmerlistComponent implements OnInit {

  farmers: any[] = [];
  filteredFarmers: any[] = [];

  constructor(private farmerService: FarmerService) { }

  ngOnInit(): void {
    this.loadAllFarmers();
  }

  loadAllFarmers(): void {
    this.farmerService.getAllFarmers().subscribe(data => {
      this.farmers = data;
      this.filteredFarmers = this.farmers;
    });
  }

  applyFilter(value: string): void {
    this.filteredFarmers = this.farmers.filter(farmer => farmer.name.includes(value) || farmer.email.includes(value));
  }

  editFarmer(id: string): void {
    // Navigate to edit page or open modal for editing
  }

  deleteFarmer(id: string): void {
    this.farmerService.deleteFarmer(id).subscribe(() => {
      this.loadAllFarmers();
    });
  }
}

