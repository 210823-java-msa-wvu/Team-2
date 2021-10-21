import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { SignInData } from 'src/app/model/signInData';


@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{
    
    signInData: SignInData | any;
    
    constructor(private authenticactionService: AuthenticationService) { }

    ngOnInit()  {

    }

    onsubmit(signInForm: NgForm){
        console.log(signInForm.value);
        const signInData = new SignInData(signInForm.value.email, signInForm.value.password)
        this.authenticactionService.authenticate(signInData);
    }
}