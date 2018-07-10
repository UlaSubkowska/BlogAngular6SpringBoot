import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import * as globals from '../globals';


@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }
  baseUrl: string = globals.apiUrl + '/users';

  async getUser(id: number) {
     let result = await this.http.get<User>(this.baseUrl + '/' + id).toPromise();
     return result;
  }
}
