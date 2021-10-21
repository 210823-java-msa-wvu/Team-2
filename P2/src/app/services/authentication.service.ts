import { Injectable } from '@angular/core';
import { SignInData } from '../model/signInData';
import { HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  isAuthenticated = false;

  private baseUrl: string = "/login";

  private headers = {'Content-Type': 'application/json'}

  constructor(private http: HttpClient) { }

  authenticate(signInData: SignInData): Observable<any>{
      return this.http.post(
        this.baseUrl,
        JSON.stringify(SignInData),
          {
            headers: this.headers,
            withCredentials: true
          }
        ).pipe(
          map(response => response),
          catchError(err => err)
        )
      
    }

  
}

