import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Photo } from '../model/photo';


@Injectable()
export class PhotoService {

  constructor(private http: HttpClient) { }
  private baseUrl: string = 'https://jsonplaceholder.typicode.com/photos';

  getPhotoAlbum(id: number){
    return this.http.get<Photo[]>(this.baseUrl + '?' + "albumId=" + id);
  }
}
