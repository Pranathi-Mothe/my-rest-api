import { Component } from '@angular/core';
import { Employee, EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-employee',
  imports: [],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {

  employees: Employee[] = [];

  constructor( public employeeService: EmployeeService){ }

  ngOnInit(): void {
   this.loadEmployees();
  }

  loadEmployees(): void {
    this.employeeService.getAllEmployees().subscribe(data => {
      this.employees = data;
    }, error => {
      console.error("Error fetching employees", error);
    });
  }
}
