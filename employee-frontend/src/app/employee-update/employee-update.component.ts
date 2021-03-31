import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
} from '@angular/forms';
import { EmployeeService } from '../_services/employee.service';
import { Employee } from '../_models/employee';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-update',
  templateUrl: './employee-update.component.html',
  styleUrls: ['./employee-update.component.css']
})
export class EmployeeUpdateComponent implements OnInit {

  public registerEmployeeForm: FormGroup;
  public employee: Employee = null;
  public employeeOrignal: Employee = null;
  public employeeId: number;

  constructor(private employeeService: EmployeeService,  private activatedRoute: ActivatedRoute) { 
    this.activatedRoute.params.subscribe(params => {
      this.employeeId = params['id'];
    });
  }


  ngOnInit() {
    this.getEmployee();
    this.createForm();
    
  }

  public getEmployee(){
    this.employeeService.getEmployee(this.employeeId).subscribe(
      (data: Employee) => {
        if (null != data) {
            this.employeeOrignal = data; 
        }
      },
      error => {
        // Catch generic error to display it to user and then rethrow so that global exception handler(CustomErrorHandler) can handle it
        // this.alertService.error('Undefined error.');
        // throw error;
      }
    );
  }

  private createForm() {
    var expression = /^(http:\/\/www\.|https:\/\/www\.|http:\/\/|https:\/\/)?[a-zA-Z0-9]+([\-\.]{1}[a-zA-Z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$/;

    this.registerEmployeeForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl(''),
      mobilePhoneNumber: new FormControl('' )
  
    });
  }

  public createEmployee() {
    this.employee = new Employee();
    this.employee.firstName = this.registerEmployeeForm.get('firstName').value;
    this.employee.lastName = this.registerEmployeeForm.get('lastName').value;
    this.employee.email = this.registerEmployeeForm.get('email').value;
    this.employee.address = this.registerEmployeeForm.get('address').value;
    this.employee.mobilePhoneNumber = this.registerEmployeeForm.get('mobilePhoneNumber').value;
    this.employee.organisation = this.employeeOrignal.organisation ? this.employeeOrignal.organisation : null;
  }

  public updateEmployee() {
    this.createEmployee();

    this.employeeService
      .updateEmployee(this.employeeId, this.employee)
      .subscribe(
        (data) => {
          if (null != data) {
            alert('Employee Successfully Updated.');
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
