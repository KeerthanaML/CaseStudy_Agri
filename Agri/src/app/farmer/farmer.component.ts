import { Component, OnInit } from '@angular/core';
import { FarmerService } from '../farmer.service';

@Component({
  selector: 'app-farmer',
  templateUrl: './farmer.component.html',
  styleUrls: ['./farmer.component.css']
})
export class FarmerComponent implements OnInit {

  farmerName: string = '';
 
  constructor(private farmerService: FarmerService) {}
 
  ngOnInit(): void {
    this.loadFarmerDetails();
  }
 
  loadFarmerDetails(): void {
    // I'm assuming you have a method in your service to get the farmer's details by their ID.
    // For simplicity, I'm hardcoding an ID here. Replace 'some-id' with your method of obtaining the farmer's ID.
    // I'm assuming you have a method in your service to get the farmer's details by their ID.
    // For simplicity, I'm hardcoding an ID here. Replace 'some-id' with your method of obtaining the farmer's ID.
    this.farmerService['getFarmerDetails']('some-id').subscribe((data: { name: string; }) => {
      this.farmerName = data.name;   // This depends on the structure of the data you're getting from the API.
    },
      (error: any) => {
      console.error('Error fetching farmer details:', error);
    });
  }
}
