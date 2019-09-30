import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {CampaignViewComponent} from './components/campaign-view/campaign-view.component';
import {EncounterComponent} from './components/encounter/encounter.component';
import { RegistrationComponent } from './components/registration/registration.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'encounter', component: EncounterComponent },
  { path: 'campaign', component: CampaignViewComponent },
  { path: 'registration', component: RegistrationComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
