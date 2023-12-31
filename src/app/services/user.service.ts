import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, map, of } from 'rxjs';
import { User } from '../models/user.model';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getUserById(userId: any){
    return this.http.get<any>(`${this.apiUrl}/user/${userId}`);
  }
  getUserByEmail(email: any){
    return this.http.get<any>(`${this.apiUrl}/user/email/${email}`);
  }

  getProgress(userId: any, courseId: any) {    
    return this.http.get<any>(`${this.apiUrl}/user/${userId}/progress/${courseId}`)
  }

  recoverAcc(email: string) {
    return this.http.get<any>(`${this.apiUrl}/user/recover/${email}`)
  }

  updateInfo(user: any) {
    return this.http.put<any>(`${this.apiUrl}/user/update`, user)
  }

  generateOtp(email: string){
    return this.http.get<any>(`${this.apiUrl}/user/otp/${email}`)
  }

  checkOtp(user: any){
    return this.http.post<any>(`${this.apiUrl}/user/otp/validate`, user)
  }

  changePassword(user: any){
    return this.http.put<any>(`${this.apiUrl}/user/password`, user)
  }
}
