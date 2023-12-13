import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CropService } from '../crop.service';

@Component({
  selector: 'app-cropslist',
  templateUrl: './cropslist.component.html',
  styleUrls: ['./cropslist.component.css']
})
export class CropslistComponent implements OnInit {

  crops: any[] = [];
  filterTerm: string = '';

  constructor(private cropService: CropService, private router: Router) { }  // Inject Router

  ngOnInit(): void {
    this.loadCrops();
  }

  loadCrops(): void {
    this.cropService.getAllCrops().subscribe(
      data => this.crops = data,
      error => console.error('Error fetching crops', error)
    );
  }


 

  orderCrop(crop: any): void {
    // Navigate to the order route with the crop ID as a parameter
    this.router.navigate(['/order', crop.cropId]);
}

 
  }



