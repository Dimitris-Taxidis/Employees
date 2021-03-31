import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Data } from '@angular/router';
import { Employee } from '../_models/employee';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private SERVER_URL = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }

  private Url = '/api';

  public getEmployees(){  
		return this.httpClient.get(this.SERVER_URL + this.Url +'/employees');  
	} 

  public getEmployee(employeeId: number){  
		return this.httpClient.get(this.SERVER_URL + this.Url +'/employee/' + employeeId);  
	} 

  public registerEmployee(employee: Employee){
    return this.httpClient.post(this.SERVER_URL + this.Url +'/employee', employee);
  }

  public updateEmployee(employeeId: number,employee: Employee){
    return this.httpClient.put(this.SERVER_URL + this.Url +'/employee/' + employeeId, employee);
  }

  public deleteEmployee(employeeId: number){
    console.log(employeeId + "  ");
    console.log(this.SERVER_URL + this.Url +'/employee/' + employeeId);
    return this.httpClient.delete(this.SERVER_URL + this.Url +'/employee/' + employeeId);
  }


}
