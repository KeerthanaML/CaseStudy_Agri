import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CropService } from '../crop.service';

@Component({
  selector: 'app-allcrops',
  templateUrl: './allcrops.component.html',
  styleUrls: ['./allcrops.component.css']
})
export class AllcropsComponent implements OnInit {

  crops: any[] = [];
  errorMessage: string = '';
  allCrops: any[] = [];
    
    filterTerm: string = '';

    constructor(private cropService: CropService) { }


  ngOnInit(): void {
    this.loadCrops();
  }

  loadCrops(): void {
    this.cropService.getAllCrops().subscribe(
        (data: any[]) => {
            this.crops = data;
            this.allCrops = data;
        },
        (error: any) => this.errorMessage = 'Failed to load crops'
    );
}
// applyFilter(event: any): void {
//   this.filterTerm = event.target.value;
//   this.crops = this.allCrops.filter(crop => crop.name.includes(this.filterTerm));
// }
applyFilter(event: any): void {
  const searchTerm = event.target.value.toLowerCase();
  this.crops = this.allCrops.filter(crop => crop.cropName && crop.cropName.toLowerCase().includes(searchTerm));
}


  deleteCrop(id: string): void {
    if (confirm('Are you sure you want to delete this crop?')) {
      this.cropService.deleteCrop(id).subscribe(
        () => {
          alert('Crop deleted successfully');
          this.loadCrops(); // Refresh the list
        },
        (error: any) => this.errorMessage = 'Failed to delete crop'
      );
    }
  }

  // A basic method to create a new crop (without a form)
  addCrop(): void {
    const newCrop = {
      // Add properties according to your model, this is just a placeholder
      name: 'New Crop',
      type: 'Type 1',
      quantity: 100,
      price: 1000
    };

    this.cropService.createCrop(newCrop).subscribe(
      () => {
        alert('Crop added successfully');
        this.loadCrops(); // Refresh the list
      },
      (error: any) => this.errorMessage = 'Failed to add crop'
    );
  }
}
