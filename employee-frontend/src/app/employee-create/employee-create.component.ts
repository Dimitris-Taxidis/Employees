import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
} from '@angular/forms';
import { EmployeeService } from '../_services/employee.service';
import { Employee } from '../_models/employee';


@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  
  public registerEmployeeForm: FormGroup;
  public employee: Employee = null;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.createForm();
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
    this.employee.organisation = null;
  }

  public registerEmployee() {
    this.createEmployee();

    this.employeeService
      .registerEmployee( this.employee)
      .subscribe(
        (data) => {
          if (null != data) {
            alert('Successfully signed up.');
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
