import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { Post } from './post';
import { Comment } from './comment';
import * as globals from './globals';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private postsUrl = globals.apiUrl + '/posts';

  constructor(
    private http: HttpClient,
  ) { }

  getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(this.postsUrl);
  }
  getPost(id: number): Observable<Post> {
    const url = `${this.postsUrl}/${id}`;
    return this.http.get<Post>(url);
  }
  getPostComments(id: number): Observable<Comment> {
    return this.http.get<Comment>(this.postsUrl + '/' + id + '/comments');
  }
}



