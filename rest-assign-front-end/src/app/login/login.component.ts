import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { DbService } from '../db.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });
  
  message:any="";

  constructor(private dbservice:DbService) { }

  ngOnInit(): void {
    
  }
  
  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.loginForm.value);
    this.dbservice.validate_user(this.loginForm.value)
    .subscribe(res => {
      this.message=res;
      console.log(res);
      console.log(this.message);
    });
  }

}
