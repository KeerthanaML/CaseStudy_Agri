import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CropService } from '../crop.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-create-crop',
  templateUrl: './create-crop.component.html',
  styleUrls: ['./create-crop.component.css']
})
export class CreateCropComponent implements OnInit {
  cropForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private cropService: CropService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm() {
    this.cropForm = this.formBuilder.group({
      cropType: ['', Validators.required],
      cropName: ['', Validators.required],
      quantity: ['', [Validators.required, Validators.min(1)]],
      price: ['', [Validators.required, Validators.min(1)]],
      location: ['', Validators.required],
      imageUrl: ['', Validators.required]
    });
  }

  submitForm() {
    if (this.cropForm.valid) {
      const newCrop = this.cropForm.value;

      // Log the newCrop data
      console.log('New Crop Data:', newCrop);

      this.cropService.createCrop(newCrop).subscribe(
        () => {
          // Notify the user of successful submission
          Swal.fire({
            title: 'Crop added successfully',
            icon: 'success',
          });

          // Navigate to another page (e.g., the crop list) after successful submission
          this.router.navigate(['/crop-list']);
        },
        (error) => {
          // Handle errors (e.g., display an error message to the user)
          console.error('There was an error adding the crop', error);
        }
      );
    }
  }

  reload() {
    location.reload();
  }
}
