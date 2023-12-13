import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  signupForm: FormGroup;
  registrationError: string = '';

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
    this.signupForm = this.formBuilder.group({
      uName: ['', Validators.required],
      uEmail: ['', [Validators.required, Validators.email]],
      uPassword: ['', [Validators.required, Validators.minLength(6)]],
      address: this.formBuilder.group({
        street: [''],
        pincode: [''],
        city: [''],
        state: [''],
        country: ['']
      }),
      uMobile: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      uRole: ['Farmer']
    });
  }

  submitForm() {
    if (this.signupForm.valid) {
      this.userService.registerUser(this.signupForm.value).subscribe(
        (response: any) => {
          console.log('Registration Data:', this.signupForm.value);
          // alert('Registered successfully!');
          Swal.fire({
            title: 'Registered successfully',
            icon: 'success',
          });
          this.router.navigate(['/login']);
        },
        (error: any) => {
          if (error.status === 409) {
            this.registrationError = 'User with this email already exists. Please choose a different email.';
          } else {
            this.registrationError = 'Registration failed. Please fill in the required fields correctly.';
          }
        }
      );
    } else {
      this.registrationError = 'Please fill in the required fields correctly.';
    }
  }
}
