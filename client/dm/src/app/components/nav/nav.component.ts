import {Component, Input, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  @Input()
  links: {};

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit() {}

  logout() {
    this.authService.currentUser = null;
    this.authService.isLoggedIn = false;
    sessionStorage.clear();
    this.router.navigate(['/login']);
  }
}
