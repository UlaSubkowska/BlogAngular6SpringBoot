
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Album } from '../model/album';
import * as globals from '../globals';

@Injectable()
export class AlbumService {

  constructor(private http: HttpClient) { }
  baseUrl: string = globals.apiUrl + '/albums';

  getAllAlbums() {
    return this.http.get<Album[]>(this.baseUrl).toPromise();
  }


}
