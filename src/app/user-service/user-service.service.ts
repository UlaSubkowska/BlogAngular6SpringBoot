import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';


@Injectable()
export class UserService {

  constructor(private http:HttpClient) { }
  baseUrl: string = 'https://jsonplaceholder.typicode.com/users';

  getUser(id:number){
    return this.http.get<User>(this.baseUrl + '/' + id);
  }
}
