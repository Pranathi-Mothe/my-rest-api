import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Employee{
 employeeId:String;
 userName:String;
 emailId:String;
}

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public apiUrl = "http://localhost:8080/api/getAllEmployees"

  constructor( private http: HttpClient) { }

public getAllEmployees(): Observable<Employee[]>{
  return this.http.get<Employee[]>(this.apiUrl);
}

}
