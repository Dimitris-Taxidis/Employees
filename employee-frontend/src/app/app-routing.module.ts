import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeUpdateComponent } from './employee-update/employee-update.component';
import { OrganisationCreateComponent } from './organisation-create/organisation-create.component';
import { NavigationComponent } from './navigation/navigation.component';
import { FooterComponent } from './footer/footer.component';

const routes: Routes = [
  { path: '', redirectTo: 'employeeList', pathMatch: 'full'},
  { path: 'employeeList', component: EmployeeListComponent },
  { path: 'employeeUpdate', component: EmployeeUpdateComponent },
  { path: 'employeeCreate', component: EmployeeCreateComponent },
  { path: 'organisationCreate', component: OrganisationCreateComponent },
  { path: 'navigation', component: NavigationComponent },
  { path: 'footer', component: FooterComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
