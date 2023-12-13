import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      uEmail: ['', [Validators.required, Validators.email]],
      uPassword: ['', Validators.required],
      uRole: ['Farmer'] // Add a role field with a default value
    });
  }

  login() {
    if (this.loginForm.valid) {
      const loginData = this.loginForm.value;

      console.log('Login data:', loginData);
      // Navigate to the component based on the selected role
      if (loginData.uRole === 'Farmer') {
        this.router.navigate(['/farmer']);
        Swal.fire({
          title: 'Farmer login successfully',
          icon: 'success',
        });
      } else if (loginData.uRole === 'Dealer') {
        this.router.navigate(['/dealer']);
        Swal.fire({
          title: 'Dealer login successfully',
          icon: 'success',
        });
      }
    } else {
      // alert('Please fill out the form correctly.');
      Swal.fire({
        title: 'Please fill out the form correctly',
        
      });
    }
  }

  goBack() {
    window.location.reload();
  }
}
