import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  username: string = '';
  password: string = '';
  whatToShow: number = 0;

  loginNow() {
    console.log(this.username, this.password);
    if (this.username === 'chocolights2020' && this.password === 'chocolights@2020') {
      this.whatToShow = 1; 
    } else {
      alert('Invalid credentials');
      this.whatToShow = 0; 
    }
  }

}
