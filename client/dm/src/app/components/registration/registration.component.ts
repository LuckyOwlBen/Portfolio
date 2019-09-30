import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../../services/registration.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registrationForm: FormGroup;
  errorMessage: string = 'red text';
  hadError: boolean = false;
  showPass: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private registrationService: RegistrationService,
    private router: Router
  ) { }

  ngOnInit() {
    this.registrationForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
      firstName: [''],
      lastName: [''],
    });
  }

  togglePass(){
    this.showPass = !this.showPass;
  }

  submitNewUser() {
    const formData = this.registrationForm.getRawValue();
    this.registrationService.addNewUser(formData).subscribe(response => {
      if(response == 'New User registered, congratulations, nerd.'){
        this.router.navigate(['/login']);
      } else {
        this.errorMessage = response;
        this.hadError = true;
      }
    });
    
  }

}
