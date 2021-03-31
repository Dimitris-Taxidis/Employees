import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EmployeeService } from '../_services/employee.service';
import { Employee } from '../_models/employee';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  public employees: Array<Employee>;

  constructor(private employeeService: EmployeeService,
              private router: Router,) { }

  ngOnInit() {
    this.getEmployees();
  }

  public getEmployees(){
    this.employeeService.getEmployees().subscribe(
      (data: Employee[]) => {
        if (null != data) {
            // console.log(data);  
            this.employees = data; 
        }
      },
      error => {
        // Catch generic error to display it to user and then rethrow so that global exception handler(CustomErrorHandler) can handle it
        // this.alertService.error('Undefined error.');
        // throw error;
      }
    );
  }

  public routeToUpdate(employeeId:number){
    this.router.navigate(['/employeeUpdate', { id: employeeId}]);
  }

  public delete(employeeId:number){
    this.employeeService.deleteEmployee(employeeId).subscribe(
      (data) => {
        if (null != data) {
          alert('Employee Successfully Deleted.');
          this.ngOnInit();
            // console.log(data);  
            // this.alertService.success('Successfully signed up.');
        }
      },
      error => {
        // Catch generic error to display it to user and then rethrow so that global exception handler(CustomErrorHandler) can handle it
        // this.alertService.error('Undefined error.');
        // throw error;
      }
    );
    
  }

}
