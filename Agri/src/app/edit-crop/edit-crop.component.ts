import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { CropService } from '../crop.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-crop',
  templateUrl: './edit-crop.component.html',
  styleUrls: ['./edit-crop.component.css']
})
export class EditCropComponent implements OnInit {

  cropForm!: FormGroup;
  cropId!: string;  

  constructor(
    private formBuilder: FormBuilder,
    private cropService: CropService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.initializeForm();

    this.cropId = this.route.snapshot.paramMap.get('id')!; // No conversion to number

    this.cropService.getCropById(this.cropId).subscribe(crop => {
      this.cropForm.patchValue(crop);
    });
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
      const updatedCrop = this.cropForm.value;

      this.cropService.updateCrop(this.cropId, updatedCrop).subscribe(
        () => {
          Swal.fire({
            title: 'Crop Updated Successfully',
            icon: 'success',
          });
          this.router.navigate(['/crop-list']);
        },
        (error) => {
          console.error('There was an error updating the crop', error);
        }
      );
    }
  }

  reload() {
    location.reload();
  }
}
