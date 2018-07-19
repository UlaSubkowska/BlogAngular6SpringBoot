import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Photo } from '../model/photo';
import * as globals from '../globals';


@Injectable()
export class PhotoService {

  constructor(private http: HttpClient) { }
  private baseUrl: string = globals.apiUrl + '/photos';

  // for workin on container version
    getPhotoAlbum(id: number) {
      return this.http.get<Photo[]>(this.baseUrl + '/' + 'albumId/' + id);
    }

    // for out api version
/*   getPhotoAlbum(id: number) {
    return this.http.get<Photo[]>(this.baseUrl + '?' + 'albumId=' + id);
  } */
}
