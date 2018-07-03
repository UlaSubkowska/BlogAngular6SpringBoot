import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Album } from '../model/album';


@Injectable()
export class AlbumService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'https://jsonplaceholder.typicode.com/albums';

  getAllAlbums(){
    return this.http.get<Album[]>(this.baseUrl);
  }


}
