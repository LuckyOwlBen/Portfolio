import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {first} from 'rxjs/operators';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit() {
    if (sessionStorage.getItem('currentUser')) {
      this.router.navigate(['/campaign']);
    }
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  // When form is submitted
  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }

    const formData = this.loginForm.getRawValue();

    this.authService.login(JSON.stringify(formData)).pipe(first()
    ).subscribe(
      data => {
        if (sessionStorage.getItem('currentUser')) {
          this.router.navigate(['/campaign']);
        }
      },
      error => {
        console.log(error);
      }
    );
  }

  gotoRegistration() {
    this.router.navigate(['/registration']);
  }
}
